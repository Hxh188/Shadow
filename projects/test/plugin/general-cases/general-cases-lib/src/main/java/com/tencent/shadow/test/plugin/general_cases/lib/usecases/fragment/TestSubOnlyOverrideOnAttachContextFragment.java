package com.tencent.shadow.test.plugin.general_cases.lib.usecases.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TestSubOnlyOverrideOnAttachContextFragment extends OnlyOverrideContextMethodBaseFragment implements TestFragment {
    public TestSubOnlyOverrideOnAttachContextFragment() {
        setArguments(new Bundle());//低版本系统上不允许attach后再setArguments
    }

    final TestFragmentCommonLogic commonLogic = new TestFragmentCommonLogic(this);

    public void setTestArguments(String msg) {
        commonLogic.setTestArguments(msg);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return commonLogic.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        commonLogic.onAttach(context);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        commonLogic.onAttach(activity);
    }

    @Override
    public void onDetach() {
        commonLogic.onDetach();
        super.onDetach();
    }

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
        commonLogic.onInflate(context, attrs, savedInstanceState);
    }

    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        commonLogic.onInflate(activity, attrs, savedInstanceState);
    }
}