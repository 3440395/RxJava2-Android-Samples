package com.rxjava2.android.samples.ui.operators;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rxjava2.android.samples.R;
import com.rxjava2.android.samples.utils.AppConstant;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by amitshekhar on 27/08/16.
 */
public class SingleObserverExampleActivity extends AppCompatActivity {

    private static final String TAG = SingleObserverExampleActivity.class.getSimpleName();
    Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

    /*
     * simple example using SingleObserver
     */
    private void doSomeWork() {
        Single.just(1)
                .compose(new SingleTransformer<Integer, MyInteger>() {
                    @Override
                    public SingleSource<MyInteger> apply(Single<Integer> upstream) {
                        return upstream.map(new Function<Integer, MyInteger>() {
                            @Override
                            public MyInteger apply(@NonNull Integer integer) throws Exception {
                                MyInteger myInteger = new MyInteger();
                                myInteger.value = integer;
                                return myInteger;
                            }
                        });
                    }
                })
                .subscribe(getSingleObserver());
    }


    int main() {
//        xxxxxxx
        return 0;
    }

    class MyInteger {
        int value;
    }

    private SingleObserver<MyInteger> getSingleObserver() {
        return new SingleObserver<MyInteger>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onSuccess(MyInteger value) {
                textView.append(" onNext : value : " + value);
                textView.append(AppConstant.LINE_SEPARATOR);
                Log.d(TAG, " onNext value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                textView.append(" onError : " + e.getMessage());
                textView.append(AppConstant.LINE_SEPARATOR);
                Log.d(TAG, " onError : " + e.getMessage());
            }
        };
    }

}