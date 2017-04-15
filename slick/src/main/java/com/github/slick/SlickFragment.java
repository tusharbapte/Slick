package com.github.slick;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.UUID;

import static com.github.slick.SlickDelegateActivity.SLICK_UNIQUE_KEY;


/**
 * @author : Pedramrn@gmail.com
 *         Created on: 2016-11-07
 */

public abstract class SlickFragment<V, P extends SlickPresenter<V>> extends Fragment implements SlickUniqueId {
    private static final String TAG = SlickFragment.class.getSimpleName();
    private SlickDelegateFragment<V, P> delegate;
    private String id;

    @Override
    @SuppressWarnings("unchecked")
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate() called");
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            id = savedInstanceState.getString(SLICK_UNIQUE_KEY);
        }
        delegate = (SlickDelegateFragment<V, P>) bind();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SLICK_UNIQUE_KEY, id);
    }


    /*@Override
    @SuppressWarnings({"unchecked", "deprecation"})
    public void onAttach(Activity activity) {
        //onAttach(Context context) is not called for android prior to marshmallow
        //onAttach(Activity activity) is called on all api levels so we can use it safely
        delegate = (SlickDelegateFragment<V, P>) bind();
        super.onAttach(activity);
    }*/

    @Override
    @SuppressWarnings("unchecked")
    public void onStart() {
        delegate.onStart((V) this);
        super.onStart();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onStop() {
        delegate.onStop((V) this);
        super.onStop();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onDestroy() {
        delegate.onDestroy((V) this);
        super.onDestroy();
    }

    @Override
    public String getUniqueId() {
        return id = id != null ? id : UUID.randomUUID().toString();
    }

    @SuppressWarnings("unchecked")
    protected abstract Object bind();
}
