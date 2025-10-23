package vn.edu.tdtu.ntan.lab05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<ApplicationProfile> appProfiles;
    RecyclerView recyclerView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        discoverInstalledApps();
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new MyAdapter(this, R.layout.recyclerview_item, appProfiles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void discoverInstalledApps() {
        PackageManager pm = getPackageManager();
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        appProfiles = new ArrayList<>();
        for (ApplicationInfo packageInfo : packages) {
            File fd = new File(packageInfo.publicSourceDir);
            appProfiles.add(new ApplicationProfile(
                    packageInfo.packageName,
                    pm.getApplicationLabel(packageInfo).toString(),
                    pm.getApplicationIcon(packageInfo),
                    fd.length(),
                    new Date(fd.lastModified())
            ));
        }
    }
}