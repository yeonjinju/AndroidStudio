package com.example.testmoudule;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // EditText와 Button 참조값을 얻어와서 지역변수에 담기
        EditText ipNum = findViewById(R.id.inputNum);
        Button tBtn = findViewById(R.id.testBtn);

        // Button에 클릭 리스너 등록 (함수 형태로 등록)
        tBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 버튼 클릭 시 동작할 코드를 작성하세요.
                // 예를 들면, EditText의 입력 값을 가져와서 처리하는 로직 등을 여기에 작성하면 됩니다.

                // EditText에서 사용자가 입력한 값을 가져오기
                String inputText = ipNum.getText().toString().trim();

                // 입력 값이 비어있는지 확인
                if (inputText.isEmpty()) {
                    showToast("정수를 입력해주세요.");
                    return;
                }

                // 입력 값을 정수로 변환
                int number = Integer.parseInt(inputText);

                // 입력한 값이 양수, 음수, 또는 0인지 판별하여 Toast 메시지 출력
                if (number > 0) {
                    showToast("입력한 숫자는 양수입니다.");
                } else if (number < 0) {
                    showToast("입력한 숫자는 음수입니다.");
                } else {
                    showToast("입력한 숫자는 0입니다.");
                }
            }
        });
    }

    // Toast 메시지를 표시하는 메소드
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
