package com.example.slidingpuzzle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    ImageView img1, img2, img3, img4, img5, img6, img7, img8,
            img9, img10, img11, img12, img13, img14, img15, img16;
    int ImgNumber = 16, steps = 0;
    TextView stepsCount, info;
    int[] ImgArray;
    Button NewPuzzle, SolvePuzzle;
    boolean gameStart = false, NewPuzzleState = true, SolvePuzzleState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);
        img7 = findViewById(R.id.img7);
        img8 = findViewById(R.id.img8);
        img9 = findViewById(R.id.img9);
        img10 = findViewById(R.id.img10);
        img11 = findViewById(R.id.img11);
        img12 = findViewById(R.id.img12);
        img13 = findViewById(R.id.img13);
        img14 = findViewById(R.id.img14);
        img15 = findViewById(R.id.img15);
        img16 = findViewById(R.id.img16);
        checkGameState(gameStart);

        NewPuzzle = findViewById(R.id.NewPuzzle);
        SolvePuzzle = findViewById(R.id.SolvePuzzle);

        stepsCount = findViewById(R.id.stepsCount);
        info = findViewById(R.id.info);
        SolvePuzzle.setEnabled(SolvePuzzleState);
    }

    //get random number for imgs
    public static int[] getRandomNum(int num){
        int[] numArray = new int[num];
        int RepeatNum;
        boolean isContinue;
        for(int i=0; i<numArray.length; i++){
            do {
                RepeatNum = (int)(Math.random()*(num+1));
                isContinue = isExistence(numArray, RepeatNum);
            } while (isContinue);
            numArray[i] = RepeatNum;
        }
        return numArray;
    }
    // the "isExistence" method
    public static boolean isExistence(int[] numArray,int RepeatNum){
        for (int i : numArray) {
            if(i == RepeatNum){
                return true;
            }
        }
        return false;
    }

    public void RandomPlace(){
        ImgArray = getRandomNum(ImgNumber);
        img1.setImageResource(getRandomImg(ImgArray[0]));
        img2.setImageResource(getRandomImg(ImgArray[1]));
        img3.setImageResource(getRandomImg(ImgArray[2]));
        img4.setImageResource(getRandomImg(ImgArray[3]));
        img5.setImageResource(getRandomImg(ImgArray[4]));
        img6.setImageResource(getRandomImg(ImgArray[5]));
        img7.setImageResource(getRandomImg(ImgArray[6]));
        img8.setImageResource(getRandomImg(ImgArray[7]));
        img9.setImageResource(getRandomImg(ImgArray[8]));
        img10.setImageResource(getRandomImg(ImgArray[9]));
        img11.setImageResource(getRandomImg(ImgArray[10]));
        img12.setImageResource(getRandomImg(ImgArray[11]));
        img13.setImageResource(getRandomImg(ImgArray[12]));
        img14.setImageResource(getRandomImg(ImgArray[13]));
        img15.setImageResource(getRandomImg(ImgArray[14]));
        img16.setImageResource(getRandomImg(ImgArray[15]));
    }

    public static int getRandomImg(int num){
        int img0 = 0;
        switch(num){
            case 1: img0 = R.drawable.img1;
                break;
            case 2: img0 = R.drawable.img2;
                break;
            case 3: img0 = R.drawable.img3;
                break;
            case 4: img0 = R.drawable.img4;
                break;
            case 5: img0 = R.drawable.img5;
                break;
            case 6: img0 = R.drawable.img6;
                break;
            case 7: img0 = R.drawable.img7;
                break;
            case 8: img0 = R.drawable.img8;
                break;
            case 9: img0 = R.drawable.img9;
                break;
            case 10: img0 = R.drawable.img10;
                break;
            case 11: img0 = R.drawable.img11;
                break;
            case 12: img0 = R.drawable.img12;
                break;
            case 13: img0 = R.drawable.img13;
                break;
            case 14: img0 = R.drawable.img14;
                break;
            case 15: img0 = R.drawable.img15;
                break;
            case 16: img0 = R.drawable.blank;
                break;
        } return img0;
    }

    public void move(View view) {
        ImageView imageView = (ImageView) view;
        info.setText("");
        if (checkBlank()==img1){
            if (imageView==img2||imageView==img5){
                checkBlank().setImageDrawable(imageView.getDrawable());
                imageView.setImageResource(R.drawable.blank);
                steps += 1;
            }
            else{
                WrongMove();
            }
        }
        else if (checkBlank()==img2){
            if (imageView==img1||imageView==img3||imageView==img6){
                checkBlank().setImageDrawable(imageView.getDrawable());
                imageView.setImageResource(R.drawable.blank);
                steps += 1;
            }
            else{
                WrongMove();
            }
        }
        else if (checkBlank()==img3){
            if (imageView==img2||imageView==img4||imageView==img7){
                checkBlank().setImageDrawable(imageView.getDrawable());
                imageView.setImageResource(R.drawable.blank);
                steps += 1;
            }
            else{
                WrongMove();
            }
        }
        else if (checkBlank()==img4){
            if (imageView==img3||imageView==img8){
                checkBlank().setImageDrawable(imageView.getDrawable());
                imageView.setImageResource(R.drawable.blank);
                steps += 1;
            }
            else{
                WrongMove();
            }
        }
        else if (checkBlank()==img5){
            if (imageView==img1||imageView==img6||imageView==img9){
                checkBlank().setImageDrawable(imageView.getDrawable());
                imageView.setImageResource(R.drawable.blank);
                steps += 1;
            }
            else{
                WrongMove();
            }
        }
        else if (checkBlank()==img6){
            if (imageView==img2||imageView==img5||imageView==img7||imageView==img10){
                checkBlank().setImageDrawable(imageView.getDrawable());
                imageView.setImageResource(R.drawable.blank);
                steps += 1;
            }
            else{
                WrongMove();
            }
        }
        else if (checkBlank()==img7){
            if (imageView==img3||imageView==img6||imageView==img8||imageView==img11){
                checkBlank().setImageDrawable(imageView.getDrawable());
                imageView.setImageResource(R.drawable.blank);
                steps += 1;
            }
            else{
                WrongMove();
            }
        }
        else if (checkBlank()==img8){
            if (imageView==img4||imageView==img7||imageView==img12){
                checkBlank().setImageDrawable(imageView.getDrawable());
                imageView.setImageResource(R.drawable.blank);
                steps += 1;
            }
            else{
                WrongMove();
            }
        }
        else if (checkBlank()==img9){
            if (imageView==img5||imageView==img10||imageView==img13){
                checkBlank().setImageDrawable(imageView.getDrawable());
                imageView.setImageResource(R.drawable.blank);
                steps += 1;
            }
            else{
                WrongMove();
            }
        }
        else if (checkBlank()==img10){
            if (imageView==img6||imageView==img9||imageView==img11||imageView==img14){
                checkBlank().setImageDrawable(imageView.getDrawable());
                imageView.setImageResource(R.drawable.blank);
                steps += 1;
            }
            else{
                WrongMove();
            }
        }
        else if (checkBlank()==img11){
            if (imageView==img7||imageView==img10||imageView==img12||imageView==img15){
                checkBlank().setImageDrawable(imageView.getDrawable());
                imageView.setImageResource(R.drawable.blank);
                steps += 1;
            }
            else{
                WrongMove();
            }
        }
        else if (checkBlank()==img12){
            if (imageView==img8||imageView==img11||imageView==img16){
                checkBlank().setImageDrawable(imageView.getDrawable());
                imageView.setImageResource(R.drawable.blank);
                steps += 1;
            }
            else{
                WrongMove();
            }
        }
        else if (checkBlank()==img13){
            if (imageView==img9||imageView==img14){
                checkBlank().setImageDrawable(imageView.getDrawable());
                imageView.setImageResource(R.drawable.blank);
                steps += 1;
            }
            else{
                WrongMove();
            }
        }
        else if (checkBlank()==img14){
            if (imageView==img10||imageView==img13||imageView==img15){
                checkBlank().setImageDrawable(imageView.getDrawable());
                imageView.setImageResource(R.drawable.blank);
                steps += 1;
            }
            else{
                WrongMove();
            }
        }
        else if (checkBlank()==img15){
            if (imageView==img11||imageView==img14||imageView==img16){
                checkBlank().setImageDrawable(imageView.getDrawable());
                imageView.setImageResource(R.drawable.blank);
                steps += 1;
            }
            else{
                WrongMove();
            }
        }
        else if (checkBlank()==img16){
            if (imageView==img12||imageView==img15){
                checkBlank().setImageDrawable(imageView.getDrawable());
                imageView.setImageResource(R.drawable.blank);
                steps += 1;
            }
            else{
                WrongMove();
            }
        }
        stepsCount.setText(String.valueOf(steps));
        CheckWin();
    }

    public ImageView checkBlank(){
        if (img1.getDrawable().getCurrent().getConstantState()==ContextCompat.getDrawable(this, R.drawable.blank).getConstantState())
            return img1;
        else if (img2.getDrawable().getCurrent().getConstantState()==ContextCompat.getDrawable(this, R.drawable.blank).getConstantState())
            return img2;
        else if (img3.getDrawable().getCurrent().getConstantState()==ContextCompat.getDrawable(this, R.drawable.blank).getConstantState())
            return img3;
        else if (img4.getDrawable().getCurrent().getConstantState()==ContextCompat.getDrawable(this, R.drawable.blank).getConstantState())
            return img4;
        else if (img5.getDrawable().getCurrent().getConstantState()==ContextCompat.getDrawable(this, R.drawable.blank).getConstantState())
            return img5;
        else if (img6.getDrawable().getCurrent().getConstantState()==ContextCompat.getDrawable(this, R.drawable.blank).getConstantState())
            return img6;
        else if (img7.getDrawable().getCurrent().getConstantState()==ContextCompat.getDrawable(this, R.drawable.blank).getConstantState())
            return img7;
        else if (img8.getDrawable().getCurrent().getConstantState()==ContextCompat.getDrawable(this, R.drawable.blank).getConstantState())
            return img8;
        else if (img9.getDrawable().getCurrent().getConstantState()==ContextCompat.getDrawable(this, R.drawable.blank).getConstantState())
            return img9;
        else if (img10.getDrawable().getCurrent().getConstantState()==ContextCompat.getDrawable(this, R.drawable.blank).getConstantState())
            return img10;
        else if (img11.getDrawable().getCurrent().getConstantState()==ContextCompat.getDrawable(this, R.drawable.blank).getConstantState())
            return img11;
        else if (img12.getDrawable().getCurrent().getConstantState()==ContextCompat.getDrawable(this, R.drawable.blank).getConstantState())
            return img12;
        else if (img13.getDrawable().getCurrent().getConstantState()==ContextCompat.getDrawable(this, R.drawable.blank).getConstantState())
            return img13;
        else if (img14.getDrawable().getCurrent().getConstantState()==ContextCompat.getDrawable(this, R.drawable.blank).getConstantState())
            return img14;
        else if (img15.getDrawable().getCurrent().getConstantState()==ContextCompat.getDrawable(this, R.drawable.blank).getConstantState())
            return img15;
        else if (img16.getDrawable().getCurrent().getConstantState()==ContextCompat.getDrawable(this, R.drawable.blank).getConstantState())
            return img16;
        else
            return null;
    }

    public void NewPuzzle(View view) {
        RandomPlace();
        steps = 0;
        stepsCount.setText(String.valueOf(steps));
        NewPuzzle.setTextColor(Color.GRAY);
        SolvePuzzle.setTextColor(Color.BLACK);

        NewPuzzle.setEnabled(NewPuzzleState);
        SolvePuzzleState = true;
        SolvePuzzle.setEnabled(SolvePuzzleState);

        gameStart = true;
        checkGameState(gameStart);
        info.setText("");
    }

    public void SolvePuzzle(View view) {
        img1.setImageResource(R.drawable.img1);
        img2.setImageResource(R.drawable.img2);
        img3.setImageResource(R.drawable.img3);
        img4.setImageResource(R.drawable.img4);
        img5.setImageResource(R.drawable.img5);
        img6.setImageResource(R.drawable.img6);
        img7.setImageResource(R.drawable.img7);
        img8.setImageResource(R.drawable.img8);
        img9.setImageResource(R.drawable.img9);
        img10.setImageResource(R.drawable.img10);
        img11.setImageResource(R.drawable.img11);
        img12.setImageResource(R.drawable.img12);
        img13.setImageResource(R.drawable.img13);
        img14.setImageResource(R.drawable.img14);
        img15.setImageResource(R.drawable.img15);
        img16.setImageResource(R.drawable.blank);

        steps = 0;
        stepsCount.setText(String.valueOf(steps));

        NewPuzzle.setTextColor(Color.BLACK);
        SolvePuzzle.setTextColor(Color.GRAY);

        NewPuzzleState = true;
        NewPuzzle.setEnabled(NewPuzzleState);
        SolvePuzzleState = false;
        SolvePuzzle.setEnabled(SolvePuzzleState);

        gameStart = false;
        checkGameState(gameStart);
        info.setText("");
    }


    public void WrongMove(){
        info.setText("Wrong Move!");
    }

    public void CheckWin(){
        if(CheckWinDetail(img1, R.drawable.img1)==1&&CheckWinDetail(img2, R.drawable.img2)==1
                &&CheckWinDetail(img3, R.drawable.img3)==1&&CheckWinDetail(img4, R.drawable.img4)==1
                &&CheckWinDetail(img5, R.drawable.img5)==1&&CheckWinDetail(img6, R.drawable.img6)==1
                &&CheckWinDetail(img7, R.drawable.img7)==1&&CheckWinDetail(img8, R.drawable.img8)==1
                &&CheckWinDetail(img9, R.drawable.img9)==1&&CheckWinDetail(img10, R.drawable.img10)==1
                &&CheckWinDetail(img11, R.drawable.img11)==1&&CheckWinDetail(img12, R.drawable.img12)==1
                &&CheckWinDetail(img13, R.drawable.img13)==1&&CheckWinDetail(img14, R.drawable.img14)==1
                &&CheckWinDetail(img15, R.drawable.img15)==1&&CheckWinDetail(img16, R.drawable.blank)==1){
            info.setText("You solved the puzzle in " + String.valueOf(steps) + " moves!");
            NewPuzzleState = true;
            NewPuzzle.setEnabled(NewPuzzleState);
            SolvePuzzleState = false;
            SolvePuzzle.setEnabled(SolvePuzzleState);
        }
    }

    public int CheckWinDetail(ImageView imageView, int DrawableId){
        if (imageView.getDrawable().getCurrent().getConstantState()==
                ContextCompat.getDrawable(this, DrawableId).getConstantState())
            return 1;
        else
            return 0;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("steps", steps);
        outState.putInt("img1", getDrawableId(img1));
        outState.putInt("img2", getDrawableId(img2));
        outState.putInt("img3", getDrawableId(img3));
        outState.putInt("img4", getDrawableId(img4));
        outState.putInt("img5", getDrawableId(img5));
        outState.putInt("img6", getDrawableId(img6));
        outState.putInt("img7", getDrawableId(img7));
        outState.putInt("img8", getDrawableId(img8));
        outState.putInt("img9", getDrawableId(img9));
        outState.putInt("img10", getDrawableId(img10));
        outState.putInt("img11", getDrawableId(img11));
        outState.putInt("img12", getDrawableId(img12));
        outState.putInt("img13", getDrawableId(img13));
        outState.putInt("img14", getDrawableId(img14));
        outState.putInt("img15", getDrawableId(img15));
        outState.putInt("img16", getDrawableId(img16));
        outState.putString("info", (String) info.getText());
        outState.putInt("NewPuzzleColor", NewPuzzle.getCurrentTextColor());
        outState.putInt("SolvePuzzleColor", SolvePuzzle.getCurrentTextColor());
        outState.putBoolean("NewPuzzleState", NewPuzzleState);
        outState.putBoolean("SolvePuzzleState", SolvePuzzleState);
        outState.putBoolean("gameStart", gameStart);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null){
            steps = savedInstanceState.getInt("steps");
            stepsCount.setText(String.valueOf(savedInstanceState.getInt("steps")));
            img1.setImageResource(savedInstanceState.getInt("img1"));
            img2.setImageResource(savedInstanceState.getInt("img2"));
            img3.setImageResource(savedInstanceState.getInt("img3"));
            img4.setImageResource(savedInstanceState.getInt("img4"));
            img5.setImageResource(savedInstanceState.getInt("img5"));
            img6.setImageResource(savedInstanceState.getInt("img6"));
            img7.setImageResource(savedInstanceState.getInt("img7"));
            img8.setImageResource(savedInstanceState.getInt("img8"));
            img9.setImageResource(savedInstanceState.getInt("img9"));
            img10.setImageResource(savedInstanceState.getInt("img10"));
            img11.setImageResource(savedInstanceState.getInt("img11"));
            img12.setImageResource(savedInstanceState.getInt("img12"));
            img13.setImageResource(savedInstanceState.getInt("img13"));
            img14.setImageResource(savedInstanceState.getInt("img14"));
            img15.setImageResource(savedInstanceState.getInt("img15"));
            img16.setImageResource(savedInstanceState.getInt("img16"));
            info.setText(savedInstanceState.getString("info"));

            NewPuzzle.setTextColor(savedInstanceState.getInt("NewPuzzleColor"));
            SolvePuzzle.setTextColor(savedInstanceState.getInt("SolvePuzzleColor"));

            NewPuzzleState = savedInstanceState.getBoolean("NewPuzzleState");
            NewPuzzle.setEnabled(savedInstanceState.getBoolean("NewPuzzleState"));

            SolvePuzzleState = savedInstanceState.getBoolean("SolvePuzzleState");
            SolvePuzzle.setEnabled(savedInstanceState.getBoolean("SolvePuzzleState"));

            gameStart = savedInstanceState.getBoolean("gameStart");
            checkGameState(savedInstanceState.getBoolean("gameStart"));
        }
    }

    public int getDrawableId(ImageView imageView){
        if (imageView.getDrawable().getCurrent().getConstantState()==
                ContextCompat.getDrawable(this, R.drawable.img1).getConstantState())
            return R.drawable.img1;
        else if (imageView.getDrawable().getCurrent().getConstantState()==
                ContextCompat.getDrawable(this, R.drawable.img2).getConstantState())
            return R.drawable.img2;
        else if (imageView.getDrawable().getCurrent().getConstantState()==
                ContextCompat.getDrawable(this, R.drawable.img3).getConstantState())
            return R.drawable.img3;
        else if (imageView.getDrawable().getCurrent().getConstantState()==
                ContextCompat.getDrawable(this, R.drawable.img4).getConstantState())
            return R.drawable.img4;
        else if (imageView.getDrawable().getCurrent().getConstantState()==
                ContextCompat.getDrawable(this, R.drawable.img5).getConstantState())
            return R.drawable.img5;
        else if (imageView.getDrawable().getCurrent().getConstantState()==
                ContextCompat.getDrawable(this, R.drawable.img6).getConstantState())
            return R.drawable.img6;
        else if (imageView.getDrawable().getCurrent().getConstantState()==
                ContextCompat.getDrawable(this, R.drawable.img7).getConstantState())
            return R.drawable.img7;
        else if (imageView.getDrawable().getCurrent().getConstantState()==
                ContextCompat.getDrawable(this, R.drawable.img8).getConstantState())
            return R.drawable.img8;
        else if (imageView.getDrawable().getCurrent().getConstantState()==
                ContextCompat.getDrawable(this, R.drawable.img9).getConstantState())
            return R.drawable.img9;
        else if (imageView.getDrawable().getCurrent().getConstantState()==
                ContextCompat.getDrawable(this, R.drawable.img10).getConstantState())
            return R.drawable.img10;
        else if (imageView.getDrawable().getCurrent().getConstantState()==
                ContextCompat.getDrawable(this, R.drawable.img11).getConstantState())
            return R.drawable.img11;
        else if (imageView.getDrawable().getCurrent().getConstantState()==
                ContextCompat.getDrawable(this, R.drawable.img12).getConstantState())
            return R.drawable.img12;
        else if (imageView.getDrawable().getCurrent().getConstantState()==
                ContextCompat.getDrawable(this, R.drawable.img13).getConstantState())
            return R.drawable.img13;
        else if (imageView.getDrawable().getCurrent().getConstantState()==
                ContextCompat.getDrawable(this, R.drawable.img14).getConstantState())
            return R.drawable.img14;
        else if (imageView.getDrawable().getCurrent().getConstantState()==
                ContextCompat.getDrawable(this, R.drawable.img15).getConstantState())
            return R.drawable.img15;
        else if (imageView.getDrawable().getCurrent().getConstantState()==
                ContextCompat.getDrawable(this, R.drawable.blank).getConstantState())
            return R.drawable.blank;
        else
            return 0;
    }

    public void checkGameState(boolean gameStart){
        img1.setEnabled(gameStart);
        img2.setEnabled(gameStart);
        img3.setEnabled(gameStart);
        img4.setEnabled(gameStart);
        img5.setEnabled(gameStart);
        img6.setEnabled(gameStart);
        img7.setEnabled(gameStart);
        img8.setEnabled(gameStart);
        img9.setEnabled(gameStart);
        img10.setEnabled(gameStart);
        img11.setEnabled(gameStart);
        img12.setEnabled(gameStart);
        img13.setEnabled(gameStart);
        img14.setEnabled(gameStart);
        img15.setEnabled(gameStart);
        img16.setEnabled(gameStart);
    }

}