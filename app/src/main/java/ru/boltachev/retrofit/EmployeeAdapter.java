package ru.boltachev.retrofit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {

    private Company company;
    private Htc htc;
    List<Employee> employees;

    public EmployeeAdapter(Htc htc) {
        this.htc = htc;
        company = htc.getCompany();
        employees = company.getEmployees();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return employee1.getName().compareTo(employee2.getName());
            }
        });

        Employee employee = employees.get(position);

        holder.name.setText(employee.getName());
        holder.phone.setText(employee.getPhoneNumber());
        holder.skills.setText(skillsToString(employee.getSkills()));
    }

    @Override
    public int getItemCount() {
        if (employees != null)
            return employees.size();
        else
            return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView phone;
        TextView skills;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.employee_name);
            phone = itemView.findViewById(R.id.employee_phone);
            skills = itemView.findViewById(R.id.employee_skills);
        }
    }

    public String skillsToString(List<String> skills) {
        String employeeSkill = "";
        for (String skill :
                skills) {
            employeeSkill += skill + " ";
        }
        return employeeSkill;
    }

}
