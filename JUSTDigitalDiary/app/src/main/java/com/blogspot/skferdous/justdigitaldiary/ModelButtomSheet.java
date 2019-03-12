package com.blogspot.skferdous.justdigitaldiary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ModelButtomSheet extends BottomSheetDialogFragment {
    private ActionListner mactionListner;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.model_content,container,false);

        Button btnA = v.findViewById(R.id.namebtn);
        Button btnB = v.findViewById(R.id.degbtn);
       // Button btnC = v.findViewById(R.id.deptbtn);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mactionListner != null){
                    mactionListner.onButtonClick(R.id.namebtn);
                    dismiss();
                }

            }
        });
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mactionListner != null){
                    mactionListner.onButtonClick(R.id.degbtn);
                    dismiss();
                }

            }
        });

      /*  btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mactionListner != null){
                    mactionListner.onButtonClick(R.id.deptbtn);
                    dismiss();
                }

            }
        });
*/

        return  v;
    }

    public void setActionListner(ActionListner actionListner) {
        mactionListner = actionListner;
    }

    interface ActionListner{
        void onButtonClick(int id);
    }
}
