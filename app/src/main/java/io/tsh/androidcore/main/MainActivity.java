package io.tsh.androidcore.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.tsh.androidcore.App;
import io.tsh.androidcore.R;

public class MainActivity extends AppCompatActivity implements MainActivityView {
    @Bind(R.id.buildType) TextView buildType;

    @Inject MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupActivityComponent();

        presenter.getBuildType();

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
