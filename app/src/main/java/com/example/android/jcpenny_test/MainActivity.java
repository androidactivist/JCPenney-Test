package com.example.android.jcpenny_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArraySet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    //TextView's
    @BindView(R.id.point_tv) TextView point_tv;
    @BindView(R.id.random_tv) TextView random_tv;
    @BindView(R.id.tv) TextView tv;

    //Buttons's
    @BindView(R.id.buttonOne) Button buttonOne;
    @BindView(R.id.buttonTwo) Button buttonTwo;
    @BindView(R.id.buttonThree) Button buttonThree;
    @BindView(R.id.buttonFour) Button buttonFour;
    @BindView(R.id.buttonFive) Button buttonFive;
    @BindView(R.id.buttonSix) Button buttonSix;
    @BindView(R.id.buttonSeven) Button buttonSeven;
    @BindView(R.id.buttonEight) Button buttonEight;
    @BindView(R.id.buttonNine) Button buttonNine;

    private List<Integer> setNames;
    private List<Integer> tempList;
    private int scoreCounter = 1;
    private boolean gameOverFlag;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setRandNumberToAllButton();
        runThread();
        setRandomNumToTextView(setNames);
        Log.d(TAG, "After shuflling : -" + setNames );
        Log.d(TAG, buttonOne.getText().toString());

    }



    //Hidding the all button's number
    private void runThread() {

        new Thread() {
            public void run() {
                    try {
                        Thread.sleep(5000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                buttonOne.setText(getResources().getString(R.string.select_num));
                                buttonTwo.setText(getResources().getString(R.string.select_num));
                                buttonThree.setText(getResources().getString(R.string.select_num));
                                buttonFour.setText(getResources().getString(R.string.select_num));
                                buttonFive.setText(getResources().getString(R.string.select_num));
                                buttonSix.setText(getResources().getString(R.string.select_num));
                                buttonSeven.setText(getResources().getString(R.string.select_num));
                                buttonEight.setText(getResources().getString(R.string.select_num));
                                buttonNine.setText(getResources().getString(R.string.select_num));

                                tv.setVisibility(View.VISIBLE);
                                random_tv.setVisibility(View.VISIBLE);

                            }
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }.start();
    }

    //Setting random number to all buttons
    private void setRandNumberToAllButton() {
        Button buttons[] = new Button[9];
        buttons[0] = buttonOne;
        buttons[1] = buttonTwo;
        buttons[2] = buttonThree;
        buttons[3] = buttonFour;
        buttons[4] = buttonFive;
        buttons[5] = buttonSix;
        buttons[6] = buttonSeven;
        buttons[7] = buttonEight;
        buttons[8] = buttonNine;

        setNames = new ArrayList<>();
        setNames.add(1);
        setNames.add(2);
        setNames.add(3);
        setNames.add(4);
        setNames.add(5);
        setNames.add(6);
        setNames.add(7);
        setNames.add(8);
        setNames.add(9);

        Log.d(TAG, "Original : -" + setNames);

        Collections.shuffle(setNames);

        for (int i = 0; i < 9; i++) {
            buttons[i].setText(setNames.get(i)+"");
        }

        tempList = new ArrayList<>();
        for(int i=0; i<setNames.size(); i++){
            tempList.add(setNames.get(i));
        }
    }

    @OnClick(R.id.buttonOne)
    public void setButtonOne() {

        if(tempList.get(0).toString().equals(random_tv.getText().toString())) {
            buttonOne.setText(random_tv.getText()+"");
            setNames.remove(new Integer(Integer.parseInt(random_tv.getText().toString())));
            Log.d(TAG, "After removing : -" + setNames);
            setRandomNumToTextView(setNames);
            scoreCounter++;
            point_tv.setText(scoreCounter+"/10");
        } else {
            showErrorMessage();
        }
    }

    @OnClick(R.id.buttonTwo)
    public void setButtonTwo() {
        if(tempList.get(1).toString().equals(random_tv.getText().toString())) {
            buttonTwo.setText(random_tv.getText()+"");
            setNames.remove(new Integer(Integer.parseInt(random_tv.getText().toString())));
            Log.d(TAG, "After removing : -" + setNames);
            setRandomNumToTextView(setNames);
            scoreCounter++;
            point_tv.setText(scoreCounter+"/10");
        } else {
            showErrorMessage();
        }
    }

    @OnClick(R.id.buttonThree)
    public void setButtonThree() {

        if(!gameOverFlag) {
            if(tempList.get(2).toString().equals(random_tv.getText().toString())) {
                buttonThree.setText(random_tv.getText()+"");
                setNames.remove(new Integer(Integer.parseInt(random_tv.getText().toString())));
                Log.d(TAG, "After removing : -" + setNames);
                setRandomNumToTextView(setNames);
                scoreCounter++;
                point_tv.setText(scoreCounter+"/10");
            } else {
                showErrorMessage();
            }
        }

    }

    @OnClick(R.id.buttonFour)
    public void setButtonFour() {
        if(!gameOverFlag) {
            if(tempList.get(3).toString().equals(random_tv.getText().toString())) {
                buttonFour.setText(random_tv.getText()+"");
                setNames.remove(new Integer(Integer.parseInt(random_tv.getText().toString())));
                Log.d(TAG, "After removing : -" + setNames);
                setRandomNumToTextView(setNames);
                scoreCounter++;
                point_tv.setText(scoreCounter+"/10");
            } else {
                showErrorMessage();
            }
        }

    }

    @OnClick(R.id.buttonFive)
    public void setButtonFive() {
        if(!gameOverFlag) {
            if(tempList.get(4).toString().equals(random_tv.getText().toString())) {
                buttonFive.setText(random_tv.getText()+"");
                setNames.remove(new Integer(Integer.parseInt(random_tv.getText().toString())));
                Log.d(TAG, "After removing : -" + setNames);
                setRandomNumToTextView(setNames);
                scoreCounter++;
                point_tv.setText(scoreCounter+"/10");
            } else {
                showErrorMessage();
            }
        }

    }

    @OnClick(R.id.buttonSix)
    public void setButtonSix() {
        if(!gameOverFlag) {
            if(tempList.get(5).toString().equals(random_tv.getText().toString())) {
                buttonSix.setText(random_tv.getText()+"");
                setNames.remove(new Integer(Integer.parseInt(random_tv.getText().toString())));
                Log.d(TAG, "After removing : -" + setNames);
                setRandomNumToTextView(setNames);
                scoreCounter++;
                point_tv.setText(scoreCounter+"/10");
            } else {
                showErrorMessage();
            }
        }

    }

    @OnClick(R.id.buttonSeven)
    public void setButtonSeven() {
        if(!gameOverFlag) {
            if(tempList.get(6).toString().equals(random_tv.getText().toString())) {
                buttonSeven.setText(random_tv.getText()+"");
                setNames.remove(new Integer(Integer.parseInt(random_tv.getText().toString())));
                Log.d(TAG, "After removing : -" + setNames);
                setRandomNumToTextView(setNames);
                scoreCounter++;
                point_tv.setText(scoreCounter+"/10");
            } else {
                showErrorMessage();
            }
        }

    }

    @OnClick(R.id.buttonEight)
    public void setButtonEight() {
        if(!gameOverFlag) {
            if(tempList.get(7).toString().equals(random_tv.getText().toString())) {
                buttonEight.setText(random_tv.getText()+"");
                setNames.remove(new Integer(Integer.parseInt(random_tv.getText().toString())));
                Log.d(TAG, "After removing : -" + setNames);
                setRandomNumToTextView(setNames);
                scoreCounter++;
                point_tv.setText(scoreCounter+"/10");
            } else {
                showErrorMessage();
            }
        }

    }

    @OnClick(R.id.buttonNine)
    public void setButtonNine() {
        if(!gameOverFlag) {
            if(tempList.get(8).toString().equals(random_tv.getText().toString())) {
                buttonNine.setText(random_tv.getText()+"");
                setNames.remove(new Integer(Integer.parseInt(random_tv.getText().toString())));
                Log.d(TAG, "After removing : -" + setNames);
                setRandomNumToTextView(setNames);
                scoreCounter++;
                point_tv.setText(scoreCounter+"/10");
            } else {
                showErrorMessage();
            }
        }
    }

    private void setRandomNumToTextView(List<Integer> numbers) {

        if(numbers.size() == 0) {
            Toast.makeText(this,"Game over!",Toast.LENGTH_SHORT).show();
            gameOverFlag = true;
            tv.setText("Game Over!");
            random_tv.setVisibility(View.GONE);

        } else {
            //0-8
            Random random = new Random();
            int index = random.nextInt(numbers.size());
            System.out.println("\nIndex :" + index );
            random_tv.setText(""+numbers.get(index));
        }


    }

    private void showErrorMessage(){
        Toast.makeText(this,"Wrong selection!",Toast.LENGTH_SHORT).show();
    }
}
