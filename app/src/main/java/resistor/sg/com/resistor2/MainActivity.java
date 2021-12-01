package resistor.sg.com.resistor2;

import android.content.Intent;
import android.content.SharedPreferences;

import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    private static final String PICKER_POSITIONS = null;
    public static int[] pickerPosArray = {1, 2, 3, 4};

    TextView resistorValue;
    ImageView bandOne, bandTwo, bandThree, bandTolerance;
    NumberPicker pickerOne, pickerTwo, pickerThree, pickerTolerance;

    public static int d1, d2;
    public static double m = 1;
    public static int tolerance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bandOne = (ImageView) findViewById(R.id.colorOne);
        bandTwo = (ImageView) findViewById(R.id.colorTwo);
        bandThree = (ImageView) findViewById(R.id.colorThree);
        bandTolerance = (ImageView) findViewById(R.id.Tolerance);
        resistorValue = (TextView) findViewById(R.id.resValue);
        pickerOne = (NumberPicker) findViewById(R.id.bandOne);
        pickerTwo = (NumberPicker) findViewById(R.id.bandTwo);
        pickerThree = (NumberPicker) findViewById(R.id.bandThree);
        pickerTolerance = (NumberPicker) findViewById(R.id.bandTolerance);
        pickerOne.setMinValue(0);
        pickerOne.setMaxValue(9);
        pickerTwo.setMinValue(0);
        pickerTwo.setMaxValue(9);
        pickerThree.setMinValue(0);
        pickerThree.setMaxValue(11);
        pickerTolerance.setMinValue(0);
        pickerTolerance.setMaxValue(4);

        pickerOne
                .setDisplayedValues(new String[]{"Black", "Brown", "Red",
                        "Orange", "Yellow", "Green", "Blue", "Violet", "Grey",
                        "White"});
        pickerTwo
                .setDisplayedValues(new String[]{"Black", "Brown", "Red",
                        "Orange", "Yellow", "Green", "Blue", "Violet", "Grey",
                        "White"});
        pickerThree
                .setDisplayedValues(new String[]{"Black", "Brown", "Red",
                        "Orange", "Yellow", "Green", "Blue", "Violet", "Grey",
                        "White", "Gold", "Silver"});

        pickerTolerance
                .setDisplayedValues(new String[]{"None", "Brown", "Red", "Gold", "Silver"});


        updateColors();

        pickerOne
                .setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                    @Override
                    public void onValueChange(NumberPicker picker, int oldVal,
                                              int newVal) {
                        d1 = newVal;

                        switch (newVal) {
                            case 0:
                                bandOne.setImageResource(R.drawable.black);
                                break;
                            case 1:
                                bandOne.setImageResource(R.drawable.brown);
                                break;
                            case 2:
                                bandOne.setImageResource(R.drawable.red);
                                break;
                            case 3:
                                bandOne.setImageResource(R.drawable.orange);
                                break;
                            case 4:
                                bandOne.setImageResource(R.drawable.yellow);
                                break;
                            case 5:
                                bandOne.setImageResource(R.drawable.green);
                                break;
                            case 6:
                                bandOne.setImageResource(R.drawable.blue);
                                break;
                            case 7:
                                bandOne.setImageResource(R.drawable.violet);
                                break;
                            case 8:
                                bandOne.setImageResource(R.drawable.grey);
                                break;
                            case 9:
                                bandOne.setImageResource(R.drawable.white);
                                break;
                        }

                        calcOhms();

                    }
                });

        pickerTwo
                .setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                    @Override
                    public void onValueChange(NumberPicker picker, int oldVal,
                                              int newVal) {
                        d2 = newVal;

                        switch (newVal) {
                            case 0:
                                bandTwo.setImageResource(R.drawable.black);
                                break;
                            case 1:
                                bandTwo.setImageResource(R.drawable.brown);
                                break;
                            case 2:
                                bandTwo.setImageResource(R.drawable.red);
                                break;
                            case 3:
                                bandTwo.setImageResource(R.drawable.orange);
                                break;
                            case 4:
                                bandTwo.setImageResource(R.drawable.yellow);
                                break;
                            case 5:
                                bandTwo.setImageResource(R.drawable.green);
                                break;
                            case 6:
                                bandTwo.setImageResource(R.drawable.blue);
                                break;
                            case 7:
                                bandTwo.setImageResource(R.drawable.violet);
                                break;
                            case 8:
                                bandTwo.setImageResource(R.drawable.grey);
                                break;
                            case 9:
                                bandTwo.setImageResource(R.drawable.white);
                                break;
                        }

                        calcOhms();
                    }
                });

        pickerThree
                .setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                    @Override
                    public void onValueChange(NumberPicker picker, int oldVal,
                                              int newVal) {
                        m = newVal;
                        switch (newVal) {
                            case 0:
                                bandThree.setImageResource(R.drawable.black);
                                m = 1;
                                break;
                            case 1:
                                bandThree.setImageResource(R.drawable.brown);
                                m = 10;
                                break;
                            case 2:
                                bandThree.setImageResource(R.drawable.red);
                                m = 100;
                                break;
                            case 3:
                                bandThree.setImageResource(R.drawable.orange);
                                m = 1000;
                                break;
                            case 4:
                                bandThree.setImageResource(R.drawable.yellow);
                                m = 10000;
                                break;
                            case 5:
                                bandThree.setImageResource(R.drawable.green);
                                m = 100000;
                                break;
                            case 6:
                                bandThree.setImageResource(R.drawable.blue);
                                m = 1000000;
                                break;
                            case 7:
                                bandThree.setImageResource(R.drawable.violet);
                                m = 10000000;
                                break;
                            case 8:
                                bandThree.setImageResource(R.drawable.grey);
                                m = 100000000;
                                break;
                            case 9:
                                bandThree.setImageResource(R.drawable.white);
                                m = 1000000000;
                                break;
                            case 10:
                                bandThree.setImageResource(R.drawable.gold);
                                m = 0.1;
                                break;
                            case 11:
                                bandThree.setImageResource(R.drawable.silver);
                                m = 0.01;
                                break;
                        }

                        calcOhms();
                    }
                });
        pickerTolerance.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                tolerance = newVal;

                switch (newVal) {
                    case 0:
                        bandTolerance.setImageResource(R.drawable.none);
                        break;
                    case 1:
                        bandTolerance.setImageResource(R.drawable.brown);
                        break;
                    case 2:
                        bandTolerance.setImageResource(R.drawable.red);
                        break;
                    case 3:
                        bandTolerance.setImageResource(R.drawable.gold);
                        break;
                    case 4:
                        bandTolerance.setImageResource(R.drawable.silver);
                        break;
                }

                calcOhms();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putIntArray(PICKER_POSITIONS, new int[]
                {pickerOne.getValue(), pickerTwo.getValue(), pickerThree.getValue(), pickerTolerance.getValue()});

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }



    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        pickerPosArray = savedInstanceState.getIntArray(PICKER_POSITIONS);

        pickerOne.setValue(pickerPosArray[0]);
        pickerTwo.setValue(pickerPosArray[1]);
        pickerThree.setValue(pickerPosArray[2]);
        pickerTolerance.setValue(pickerPosArray[3]);

        updateColors();
        calcOhms();
    }


    @Override
    public void onResume() {
        super.onResume();
        updateColors();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void updateColors() {
        SharedPreferences prefs;
        prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        int text_color = prefs.getInt("text_color", Color.BLACK);
        int bg_color = prefs.getInt("bg_color", Color.WHITE);

        resistorValue.setTextColor(text_color);

        RelativeLayout rL = (RelativeLayout) findViewById(R.id.mainlayout);
        rL.setBackgroundColor(bg_color);

    }

    public void calcOhms() {

        double ohmage = ((d1 * 10) + d2) * m;
        long ohms = Math.round(ohmage);
        String toleranceValue;

        DecimalFormat df = new DecimalFormat("#.##");
        ohmage = Double.valueOf(df.format(ohmage));

        String Result;

        switch (tolerance) {
            case 0:
                toleranceValue = "+/- 20%";
                break;
            case 1:
                toleranceValue = "+/- 1%";
                break;
            case 2:
                toleranceValue = "+/- 2%";
                break;
            case 3:
                toleranceValue = "+/- 5%";
                break;
            case 4:
                toleranceValue = "+/- 5%";
                break;
            default:
                toleranceValue = "+/- 20%";
                break;
        }

        if (ohmage > 0 && ohmage < 1000 && ohmage % 1 != 0)
            Result = "" + ohmage + " Ohms " + toleranceValue;
        else if (ohmage > 0 && ohmage < 1000 && ohmage % 1 == 0)
            Result = "" + ohms + " Ohms " + toleranceValue;
        else if (ohmage >= 1000 && ohmage < 1000000)
            Result = "" + (ohms / 1000) + " KOhms " + toleranceValue;
        else if (ohmage >= 1000000) Result = "" + (ohms / 1000000) + " MOhms " + toleranceValue;
        else Result = "Invalid Value " + toleranceValue;

        resistorValue.setText(Result);

    }


}
