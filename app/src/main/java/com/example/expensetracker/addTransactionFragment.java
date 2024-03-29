package com.example.expensetracker;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.expensetracker.databinding.FragmentAddTransactionBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.SimpleFormatter;


public class addTransactionFragment extends BottomSheetDialogFragment {

    public addTransactionFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    FragmentAddTransactionBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentAddTransactionBinding.inflate(inflater);


        binding.incomeBtn.setOnClickListener(view->{
            binding.incomeBtn.setBackground(getContext().getDrawable(R.drawable.income));
            binding.ExpenseBtn.setBackground(getContext().getDrawable(R.drawable.default_selector));
            binding.ExpenseBtn.setTextColor(getContext().getColor(R.color.textColor));
            binding.incomeBtn.setTextColor(getContext().getColor(R.color.greenColor));
        });

        binding.ExpenseBtn.setOnClickListener(view->{
            binding.incomeBtn.setBackground(getContext().getDrawable(R.drawable.default_selector));
            binding.ExpenseBtn.setBackground(getContext().getDrawable(R.drawable.expense));
            binding.ExpenseBtn.setTextColor(getContext().getColor(R.color.textColor));
            binding.incomeBtn.setTextColor(getContext().getColor(R.color.redColor));
        });


        binding.date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext());
                datePickerDialog.setOnDateSetListener((datePicker,i,i1,i2)->{
                    Calendar calendar =Calendar.getInstance();
                    calendar.set(Calendar.DAY_OF_MONTH,datePicker.getDayOfMonth());
                    calendar.set(Calendar.MONTH,datePicker.getMonth());
                    calendar.set(Calendar.YEAR,datePicker.getYear());

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM,yyyy");
                    String dateToShow = dateFormat.format(calendar.getTime());

                    binding.date.setText(dateToShow);
                });
                datePickerDialog.show();
            }
        });



        return binding.getRoot();
    }
}