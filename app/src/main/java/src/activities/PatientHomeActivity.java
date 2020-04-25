package src.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;

import e.wolfsoft1.src.R;
import src.customfonts.MyTextView_Roboto_Regular;

public class PatientHomeActivity extends HomeActivity {

    protected String consultStatus[]={"Pending", "In Progress", "Resolved"};
    protected String consultDates[]={"14 Aug 2019","10 Mar 2019","22 Feb 2019"};
    protected String consultSymptoms[]={"Insomnia Headaches Confusion", "Insomnia Headaches Confusion", "Insomnia Headaches Confusion"};
    protected String bedcount[]={"3","3","3"};
    protected String carParking[]={"1","1","1"};
    protected String swimmingpool[]={"1","1","1"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home);
        PatientHomeActivity.this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        LinearLayout consultList = findViewById(R.id.consult_list);

        for(int i = 0; i < consultStatus.length; i++ ){
            View consult = creatConsultCard(consultStatus[i], consultDates[i], consultSymptoms[i]);
            consultList.addView(consult);
        }

    }

    private View creatConsultCard(String consultStatus, String consultDate, String consultSymptom) {
        View consult = getLayoutInflater().inflate(R.layout.consultation_card_view, null);

        ((TextView) consult.findViewById(R.id.consult_date_day)).setText(consultDate.split(" ")[0]);
        ((TextView) consult.findViewById(R.id.consult_date_month)).setText(consultDate.split(" ")[1]);
        ((TextView) consult.findViewById(R.id.consult_date_year)).setText(consultDate.split(" ")[2]);

        ((TextView) consult.findViewById(R.id.consult_status)).setText(consultStatus);
        ((TextView) consult.findViewById(R.id.consult_status)).setTextColor(getResources().getColor(R.color.colorStatusPending));

        for(String sym: consultSymptom.split(" ")){
            TextView chip = createChip(sym, getApplicationContext());
            ((FlexboxLayout) consult.findViewById(R.id.selected_symptoms_layout)).addView(chip);
        }
        ((TextView) consult.findViewById(R.id.symptom_description)).setText(getResources().getString(R.string.description));

        consult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), CommentsEditableConsultActivity.class);
                getApplicationContext().startActivity(intent);
            }
        });

        return consult;
    }

    private TextView createChip(CharSequence symptom_name, Context context) {
        MyTextView_Roboto_Regular chip = new MyTextView_Roboto_Regular(context);
        chip.setText(symptom_name);
        chip.setBackgroundResource(R.drawable.facilities_rect);
        chip.setPadding(20,20, 20, 20);
        chip.setBackgroundResource(R.color.colorSecondaryLightBlue);

        TableRow.LayoutParams chip_layout_params = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        chip_layout_params.setMargins(10, 10, 10, 10);
        chip.setLayoutParams(chip_layout_params);
        return chip;
    }


}
