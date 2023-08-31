package com.section.adapter.demo;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.List;

/**
 * @Desc:
 * @Author: hkk
 * @Date: 2023/8/29
 */
public class CheckSectionAdapter extends BaseSectionQuickAdapter<InspectionSection, BaseViewHolder> {

    public CheckSectionAdapter(int layoutResId, int sectionHeadResId, List<InspectionSection> data) {
        super(sectionHeadResId, data);
        setNormalLayout(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, InspectionSection inspectionSection) {
        CheckMaterialBean checkMaterialBean = inspectionSection.getCheckMaterialBean();
        holder.setText(R.id.tv_content, checkMaterialBean.getInspectionContent());
        if (checkMaterialBean.getIsInspection() == 0) {
            ((RadioButton)holder.findView(R.id.rb_check_not)).setChecked(true);
        } else if (checkMaterialBean.getIsInspection() == 1){
            ((RadioButton)holder.findView(R.id.rb_check_yes)).setChecked(true);
        }
        ((RadioGroup)holder.findView(R.id.rg_check)).setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_check_yes:
                    checkMaterialBean.setIsInspection(1);
                    break;
                case R.id.rb_check_not:
                    checkMaterialBean.setIsInspection(0);
                    break;
            }
        });
    }

    @Override
    protected void convertHeader(@NonNull BaseViewHolder holder, @NonNull InspectionSection inspectionSection) {
        CheckMaterialBean checkMaterialBean = inspectionSection.getCheckMaterialBean();
        holder.setText(R.id.tv_title, checkMaterialBean.getInspectionContentType());
    }

    public void setSectionList(List<InspectionSection> list) {
        replaceData(list);
    }
}
