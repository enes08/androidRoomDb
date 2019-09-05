package com.enes_08.androidroom.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.enes_08.androidroom.R;
import com.enes_08.androidroom.entitiy.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StundetViewHolder> {


    private Context mContext;
    private List<Student> mStudents;
    private LayoutInflater mInflater;
    private LinearLayoutManager mLayoutManager;
    private Callback mCallBack;

    public StudentAdapter(android.content.Context mContext, List<Student> students) {
        mInflater = LayoutInflater.from(mContext);
        mLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);

        this.mContext = mContext;
        this.mStudents = students;
    }

    @NonNull
    @Override
    public StundetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = mInflater.inflate(R.layout.item_student, parent, false);
        StundetViewHolder holder = new StundetViewHolder(item);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StundetViewHolder holder, int position) {


         Student student= mStudents.get(position);
        StundetViewHolder stundetViewHolder = (StundetViewHolder) holder;



        stundetViewHolder.tvName.setText(student.getName());
        stundetViewHolder.tvSurName.setText(student.getSurName());
        stundetViewHolder.tvNo.setText(student.getNo()+"");
        stundetViewHolder.tvClass.setText(student.getStudentClass());



        stundetViewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallBack.deleteStudent(student);

            }
        });


    }
    @Override
    public void onAttachedToRecyclerView(@NonNull final RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.setLayoutManager(mLayoutManager);
    }


    @Override
    public int getItemCount() {
        return mStudents.size();
    }

    public static class StundetViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvSurName;
        TextView tvNo;
        TextView tvClass;
        Button btnDelete;

        public StundetViewHolder(@NonNull View itemView) {
            super(itemView);

             tvName= itemView.findViewById(R.id.tvName);
             tvSurName= itemView.findViewById(R.id.tvsurName);
             tvNo=itemView.findViewById(R.id.tvNo);
             tvClass= itemView.findViewById(R.id.tvClass);
            btnDelete=itemView.findViewById(R.id.btnDelete);
        }
    }


    public void setCallback(Callback callback){
        mCallBack=callback;
    }

    public interface Callback{


        void deleteStudent(Student student);

    }
}
