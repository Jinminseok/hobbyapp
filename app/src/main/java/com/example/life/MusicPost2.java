package com.example.life;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MusicPost2 extends AppCompatActivity {

    private final String fileName = "access.cnt" ;
    private int accessCount = 0 ;

    private FirebaseFirestore mStore = FirebaseFirestore.getInstance();

    private TextView mTitleText, mContentsText, mNameText;
    private String id;

    Button btn;
    EditText editText;
    TextView textView;
    List<String> commentsListm; // 댓글 목록을 저장하는 리스트

    private int loadAccessCount() {
        FileInputStream fis = null ;
        BufferedInputStream bufis = null ;
        byte[] buf = new byte[4] ;
        int size = 0 ;
        int count = 0 ;

        File file = new File(getFilesDir(), fileName) ;

        System.out.println("load FILE : " + file.getAbsolutePath()) ;

        if (file.exists()) {
            try {
                // open file.
                fis = new FileInputStream(file);
                bufis = new BufferedInputStream(fis);

                // read data from bufis's buffer.
                if ((size = bufis.read(buf)) != -1) {
                    // convert byte array to int.
                    for (int i = 0; i < size; i++) {
                        count |= (int) (buf[i] << (24 - (i * 8)));
                    }
                }

                // close file.
                bufis.close() ;
                fis.close() ;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return count ;
    }

    private void saveAccessCount(int count) {
        FileOutputStream fos = null ;
        BufferedOutputStream bufos = null ;

        byte[] buf = new byte[4] ;

        // convert int to byte array.
        buf[0] = (byte)((count >> 24) & 0xFF) ;
        buf[1] = (byte)((count >> 16) & 0xFF) ;
        buf[2] = (byte)((count >> 8) & 0xFF) ;
        buf[3] = (byte)(count & 0xFF) ;

        File file = new File(getFilesDir(), fileName) ;

        System.out.println("save FILE : " + file.getAbsolutePath()) ;

        try {
            // open file.
            fos = new FileOutputStream(file) ;
            bufos = new BufferedOutputStream(fos) ;

            // write file.
            bufos.write(buf) ;

        } catch (Exception e) {
            e.printStackTrace() ;
        }

        try {
            // close file.
            if (bufos != null)
                bufos.close() ;

            if (fos != null)
                fos.close() ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ... 코드 계속



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_post2);

        btn = findViewById(R.id.comment_button);
        editText = findViewById(R.id.comment_editText);
        textView = findViewById(R.id.textView);

        mTitleText = findViewById(R.id.post2_title);
        mContentsText = findViewById(R.id.post2_contents);
        mNameText = findViewById(R.id.post2_name);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = editText.getText().toString();

                if (!comment.isEmpty()) {
                    commentsListm.add(comment);
                    updateCommentsTextView();
                    Toast.makeText(MusicPost2.this, "댓글이 작성되었습니다.", Toast.LENGTH_SHORT).show();
                }
                editText.setText("");
            }
        });

        Intent getIntent = getIntent();
        id = getIntent().getStringExtra(FirebaseID.documentId);
        Log.e("Item document id: ", id);

        mStore.collection(FirebaseID.musicpost).document(id)
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            if (task.getResult().exists()) {
                                if (task.getResult() != null) {
                                    Map<String, Object> snap = task.getResult().getData();
                                    String title = String.valueOf(snap.get(FirebaseID.title));
                                    String contents = String.valueOf(snap.get(FirebaseID.contents));
                                    String name = String.valueOf(snap.get(FirebaseID.nicname));

                                    mTitleText.setText(title);
                                    mContentsText.setText(contents);
                                    mNameText.setText("작성자:" + name);

                                }
                            } else {
                                Toast.makeText(MusicPost2.this, "삭제된 문서입니다.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });

        commentsListm = new ArrayList<>();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeleteConfirmationDialog();
            }
        });

        restoreState();

        ImageButton buttonFavorite = findViewById(R.id.comment_button2);
        buttonFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MusicPost2.this, LikeBoard.class);
                intent.putExtra("title", mTitleText.getText().toString());
                intent.putExtra("contents", mContentsText.getText().toString());
                Toast.makeText(MusicPost2.this, "게시글이 찜 되었습니다.", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }

    private void updateCommentsTextView() {
        StringBuilder sb = new StringBuilder();
        for (String comment : commentsListm) {
            sb.append(comment).append("\n");
        }
        textView.setText(sb.toString());
        saveState();
    }

    private void saveState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("comment", editText.getText().toString());
        editor.putString("commentsListm", commentsListToString());
        editor.commit();
    }

    private void restoreState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if ((pref != null) && (pref.contains("comment")) && (pref.contains("commentsListm"))) {
            String comment = pref.getString("comment", "");
            String commentsListString = pref.getString("commentsListm", "");
            editText.setText(comment);
            commentsListm = stringToCommentsList(commentsListString);
            updateCommentsTextView();
        }
    }

    private String commentsListToString() {
        StringBuilder sb = new StringBuilder();
        for (String comment : commentsListm) {
            sb.append(comment).append(";");
        }
        return sb.toString();
    }

    private List<String> stringToCommentsList(String commentsListString) {
        String[] commentsArray = commentsListString.split(";");
        List<String> commentsList = new ArrayList<>();
        for (String comment : commentsArray) {
            if (!comment.isEmpty()) {
                commentsList.add(comment);
            }
        }
        return commentsList;
    }

    private void showDeleteConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("해당 댓글을 삭제하시겠습니까?")
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteComment();
                        Toast.makeText(MusicPost2.this, "댓글이 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void deleteComment() {
        String clickedComment = commentsListm.get(commentsListm.size() - 1);
        commentsListm.remove(clickedComment);
        updateCommentsTextView();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveState();
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreState();
    }
}

