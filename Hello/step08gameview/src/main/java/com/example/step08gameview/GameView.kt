package com.example.step08gameview

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.os.Handler
import android.os.Message
import android.util.AttributeSet
import android.view.View



class GameView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?=null
) : View(context, attrs) { // 부모클래스를 표현하는 식

    lateinit var handler2:Handler
    //사용할 필드를 미리 만들기
    lateinit var backImg:Bitmap
    //화면의 폭과 높이를 저장할 필드
    private var width=0
    private var height=0
    //배경이미지의 y 좌표
    var back1Y=0
    var back2Y=0

    //게임 화면을 준비하는 함수
    fun init(){
        //사용할 이미지를 미리 로딩해서 참조값을 필드에 저장하기
        //원본 이미지
        var backImg:Bitmap = BitmapFactory.decodeResource(resources, R.drawable.backbg)
        //원본 이미지를 원하는 크기로 변경해서 필드에 저장하기
        this.backImg=Bitmap.createScaledBitmap(backImg, width, height, false)

        //Handler 객체를 init 블럭에서 생성해서 참조값을 필드에 넣어둔다.
        handler2=object:Handler() {
            //Handler 객체에 메세지가 도착하면 호출되는 메소드
            override fun handleMessage(msg: Message) {
                //화면 갱신하기
                invalidate()
                // handler 객체에 빈 메시지를 20/1000 초 이후에 다시 보내기
                sendEmptyMessageDelayed(0, 20)
            }
        }
        //Handler 객체에 빈메세지를 한번 보내기
        handler2.sendEmptyMessageDelayed(0, 20)
    }

    //onDraw() 메소드에서 화면 구성하기
    override fun onDraw(canvas: Canvas?) {
        //배경이미지, 유닛 아미지, 적군이미지 등등 그리기
        canvas?.drawBitmap(backImg, 0f, back1Y.toFloat(), null)
        canvas?.drawBitmap(backImg, 0f, back2Y.toFloat(), null)
        //배경이미지 관련 처리
        back1Y += 5
        back2Y += 5
        //만일 배경1 의 좌표가 아래로 벗어 난다면
        if(back1Y >= height){
            // 배경1를 상단으로 다시 보낸다.
            back1Y = -height
            // 배경2와 오차가 생기지 않게 하기위해 복원하기
            back2Y = 0
        }
        // 만일 배경 2의 좌표가 아래로 벗어나면
        if (back2Y >= height) {
            // 배경2를 상단으로 다시 보낸다.
            back2Y = -height
            // 배경1와 오차가 생기지 않게 하기위해 복원하기
            back1Y = 0
        }

    }
    //View 가 차지하고 있는 영역의 width 와 height 가 전달되는 메소드
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        //전달되는 폭과 높이를 필드에 저장
        width=w
        height=h

        //배경 이미지의 초기좌표
        back2Y = -height
        //초기화 함수 호출
        init()
    }
}







