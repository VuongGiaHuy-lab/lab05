package vn.edu.tdtu.ntan.lab05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private int layoutId;
    private List<ApplicationProfile> appProfiles;
    public MyAdapter(Context context, int layoutId, List<ApplicationProfile> appProfiles) {
        this.context = context;
        this.layoutId = layoutId;
        this.appProfiles = appProfiles;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        return new MyViewHolder(layoutInflater.inflate(this.layoutId, null, false),
                         this);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ApplicationProfile applicationProfile = appProfiles.get(position);
        holder.update(applicationProfile);
    }

    @Override
    public int getItemCount() {
        return appProfiles.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
                    implements View.OnClickListener {
        private MyAdapter adapter;
        private ImageView imageViewIcon;
        private TextView txtTitle;

        public MyViewHolder(@NonNull View itemView, MyAdapter adapter) {
            super(itemView);
            imageViewIcon = itemView.findViewById(R.id.imageViewIcon);
            imageViewIcon.setOnClickListener(this);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtTitle.setOnClickListener(this);
        }

        public void update(ApplicationProfile appProfile) {
            imageViewIcon.setImageDrawable(appProfile.getAppIcon());
            txtTitle.setText(appProfile.getTitle());
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(MyAdapter.this.context, "Hello",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
