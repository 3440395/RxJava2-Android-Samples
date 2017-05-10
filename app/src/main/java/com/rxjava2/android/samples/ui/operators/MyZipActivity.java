package com.rxjava2.android.samples.ui.operators;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.rxjava2.android.samples.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function4;
import io.reactivex.schedulers.Schedulers;

/**
 * 分别请求多组数据，然后结合起来
 * Created by xuekai on 2017/5/10.
 */
public class MyZipActivity extends AppCompatActivity {

    private static final String TAG = MyZipActivity.class.getSimpleName();
    Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        btn = (Button) findViewById(R.id.btn);
        textView = (TextView) findViewById(R.id.textView);

        ProgressBar progressBar = new ProgressBar(this);
        ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
        root.addView(progressBar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doSomeWork();
            }
        });
    }

    /*
    * 有三个网络请求，分别请求三个数据，然后结合起来
    */
    private void doSomeWork() {
        Observable
                .zip(getName(), getAge(), getSex(), getSex(), new Function4<Name, Age, Sex, Sex, User>() {
                    @Override
                    public User apply(@NonNull Name name, @NonNull Age age, @NonNull Sex sex, @NonNull Sex sex2) throws Exception {
                        User user = new User();
                        user.name = name;
                        user.age = age;
                        user.sex = sex;
                        user.sex2 = sex2;
                        return user;
                    }
                })
                .subscribeOn(Schedulers.newThread())
                // Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<User>() {
                    @Override
                    public void accept(@NonNull User user) throws Exception {
                        Log.e(TAG, "accept" + user);
                    }
                });
    }


    private ObservableSource<Name> getName() {
        return Observable.create(new ObservableOnSubscribe<Name>() {
            @Override
            public void subscribe(ObservableEmitter<Name> e) throws Exception {
                Log.e(TAG, "getName start");
                Thread.sleep(1000);
                Log.e(TAG, "getName end");

                Name name = new Name();
                name.value = "姓名";
                e.onNext(name);
                e.onComplete();// TODO: by xk 2017/5/10 11:13
            }
        })
                .subscribeOn(Schedulers.newThread());
    }

    private ObservableSource<Sex> getSex() {
        return Observable.create(new ObservableOnSubscribe<Sex>() {
            @Override
            public void subscribe(ObservableEmitter<Sex> e) throws Exception {
                Log.e(TAG, "getSex start");
                Thread.sleep(2000);
                Log.e(TAG, "getSex end");

                Sex sex = new Sex();
                sex.value = "男";
                e.onNext(sex);
                e.onComplete();// TODO: by xk 2017/5/10 11:13
            }
        }).subscribeOn(Schedulers.newThread());
    }

    private ObservableSource<Age> getAge() {
        return Observable.create(new ObservableOnSubscribe<Age>() {
            @Override
            public void subscribe(ObservableEmitter<Age> e) throws Exception {
                Log.e(TAG, "getAge start");


                Thread.sleep(3000);
                Log.e(TAG, "getAge end");

                Age age = new Age();
                age.value = "15";
                e.onNext(age);
                e.onComplete();// TODO: by xk 2017/5/10 11:13
            }
        }).subscribeOn(Schedulers.newThread());
    }

    class Name {
        String value;

        @Override
        public String toString() {
            return "Name{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }

    class Sex {
        String value;

        @Override
        public String toString() {
            return "Sex{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }

    class Age {
        String value;

        @Override
        public String toString() {
            return "Age{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }

    class User {
        Name name;
        Sex sex;
        Sex sex2;
        Age age;

        @Override
        public String toString() {
            return "User{" +
                    "name=" + name +
                    ", sex=" + sex +
                    ", sex2=" + sex2 +
                    ", age=" + age +
                    '}';
        }
    }
}