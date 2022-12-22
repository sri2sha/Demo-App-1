package com.example.dempapp1.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dempapp1.R;

public class EmployeeDetailAdapter extends RecyclerView.Adapter<EmployeeDetailAdapter.ViewHolder> {
    private final EmployeeModelData[] employeeModelData;

    public EmployeeDetailAdapter(EmployeeModelData[] employeeModelData) {
        this.employeeModelData = employeeModelData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.layout_employee_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final EmployeeModelData mEmployeeModelData = employeeModelData[position];
        holder.textViewId.setText(employeeModelData[position].getEmployeeId());
        holder.textViewName.setText(employeeModelData[position].getEmployeeName());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), mEmployeeModelData.getEmployeeName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return employeeModelData.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public AppCompatTextView textViewId;
        public AppCompatTextView textViewName;
        public ConstraintLayout constraintLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.textViewId = (AppCompatTextView) itemView.findViewById(R.id.tvEmployeeId);
            this.textViewName = (AppCompatTextView) itemView.findViewById(R.id.tvEmployeeName);
            constraintLayout = (ConstraintLayout) itemView.findViewById(R.id.clParent);
        }
    }

}
