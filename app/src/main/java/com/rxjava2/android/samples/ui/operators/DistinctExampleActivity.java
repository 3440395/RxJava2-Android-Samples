package com.rxjava2.android.samples.ui.operators;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rxjava2.android.samples.R;
import com.rxjava2.android.samples.utils.AppConstant;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 过滤重复元素
 * Created by techteam on 13/09/16.
 */
public class DistinctExampleActivity extends AppCompatActivity {

    private static final String TAG = DistinctExampleActivity.class.getSimpleName();
    Button btn;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        btn = (Button) findViewById(R.id.btn);
        textView = (TextView) findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doSomeWork();
            }
        });
    }


    private void doSomeWork() {

        getObservable()
                .distinct()
                .subscribe(getObserver());
    }

    private Observable<User> getObservable() {
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        User user5 = new User();
        User user55 = new User();
        user1.value=1;
        user2.value=2;
        user3.value=3;
        user4.value=4;
        user5.value=5;
        user55.value=5;
        return Observable.just(user1, user2, user1, user4, user1, user3,user5,user55);
    }


    private Observer<User> getObserver() {
        return new Observer<User>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(User value) {
                textView.append(" onNext : value : " + value);
                textView.append(AppConstant.LINE_SEPARATOR);
                Log.d(TAG, " onNext value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, " onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, " onComplete");
            }
        };
    }

    class User{
        int value;

        @Override
        public String toString() {
            return "user is "+value;
        }
    }
}