package com.section.adapter.demo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CheckMaterialView extends LinearLayout {

    RecyclerView rvCheckList;

    private Context context;
    private List<InspectionSection> mData;
    private CheckSectionAdapter mAdapter;

    private OnCheckMaterialListener listener;

    public CheckMaterialView(Context context) {
        super(context);
        init(context);
    }

    public CheckMaterialView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CheckMaterialView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.view_check_material, this);
        rvCheckList = findViewById(R.id.rv_list);
        initRv();

        findViewById(R.id.tv_next).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onNext();
            }
        });
        findViewById(R.id.tv_all_ok).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllOK();
            }
        });
    }

    private void initRv() {
        rvCheckList.setLayoutManager(new GridLayoutManager(context, 2));
        rvCheckList.addItemDecoration(new GridSectionAverageGapItemDecoration(10, 10, 20, 15));

        mData = newCheckList();
        mAdapter = new CheckSectionAdapter(R.layout.item_section_content, R.layout.item_section_head, mData);
        rvCheckList.setAdapter(mAdapter);
    }

    public List<InspectionSection> newCheckList() {
        List<InspectionSection> checkList = new ArrayList<>();
        checkList.add(new InspectionSection(new CheckMaterialBean(0, "储运查验")));
        checkList.add(new InspectionSection(new CheckMaterialBean(1, "car_inspection")));
        checkList.add(new InspectionSection(new CheckMaterialBean(1, "temperature_inspection")));
        checkList.add(new InspectionSection(new CheckMaterialBean(1, "quarantine_inspection")));
        checkList.add(new InspectionSection(new CheckMaterialBean(1, "retained_inspection")));
        checkList.add(new InspectionSection(new CheckMaterialBean(1, "consistency_inspection")));
        checkList.add(new InspectionSection(new CheckMaterialBean(0, "原料查验")));
        checkList.add(new InspectionSection(new CheckMaterialBean(2, "corrupt_inspection")));
        checkList.add(new InspectionSection(new CheckMaterialBean(2, "smell_inspection")));
        checkList.add(new InspectionSection(new CheckMaterialBean(2, "trademark_inspection")));
        checkList.add(new InspectionSection(new CheckMaterialBean(2, "source_inspection")));
        checkList.add(new InspectionSection(new CheckMaterialBean(2, "validity_inspection")));
        return checkList;
    }

    private void setAllOK() {
        for (InspectionSection inspection: mData) {
            if (inspection.getCheckMaterialBean().getInspectionType() == 1) {
                inspection.getCheckMaterialBean().setIsInspection(1);
            }
            if (inspection.getCheckMaterialBean().getInspectionType() == 2) {
                inspection.getCheckMaterialBean().setIsInspection(0);
            }
        }
        Log.e("HKK", "mData = " + mData);
//        mAdapter = new CheckSectionAdapter(R.layout.item_section_content, R.layout.item_section_head, mData);
//        rvCheckList.setAdapter(mAdapter);

//        mAdapter.getData().clear();
//        mAdapter.getData().addAll(mData);

//        mAdapter.setSectionList(mData);
//        mAdapter.setNewData(mData);
    }

    public List<CheckMaterialBean> getCheckList() {
        List<CheckMaterialBean> checkList = new ArrayList<>();
        for (InspectionSection inspection: mData) {
            if (!inspection.isHeader()) {
                checkList.add(inspection.getCheckMaterialBean());
            }
        }
        return checkList;
    }

    public void setOnSearchMaterialListener(OnCheckMaterialListener listener) {
        this.listener = listener;
    }
}
