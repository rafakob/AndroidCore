package io.tsh.androidcore.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.tsh.androidcore.App;
import io.tsh.androidcore.R;

public class MainActivity extends AppCompatActivity implements MainActivityView {
    @Bind(R.id.buildType) TextView buildType;
    @Bind(R.id.dbSnappy) TextView dbSnappy;
    @Bind(R.id.dbFlow) TextView dbFlow;
    @Bind(R.id.dbRealm) TextView dbRealm;

    @Inject MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupActivityComponent();

        presenter.getBuildType();
        presenter.getPersonData();
    }


    @OnClick(R.id.rerun)
    public void onRerunClick(View view) {
        presenter.runSnappy(this);
        presenter.runDbFlow(this);
        presenter.runRealm();
    }


    @Override
    public void updateTimeSnappy(String time) {
        this.dbSnappy.setText("Snappy: " + time);
    }

    @Override
    public void updateTimeDbFlow(String time) {
        this.dbFlow.setText("DbFlow: " + time);
    }

    @Override
    public void updateTimeRealm(String time) {
        this.dbRealm.setText("Realm: " + time);
    }

    private void setupActivityComponent() {
        App.get(this).getAppComponent()
                .plus(new MainActivityModule(this))
                .inject(this);
    }

    @Override
    public void updateBuildType(String s) {
        buildType.setText(s);
    }
}
