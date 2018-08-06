package com.xdx.doall.griddialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xdx on 2018/8/3.
 */

public class InsurDialog extends Dialog {

    SelectInsurDialog.DialogCallback callback;
    String name ;
    int id ;
    Button sure;
    InsurGridViewAdapt mAdapter;
    List<InsurEntity> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomeDialog();

    }

    public void setList(List<InsurEntity> listData){
        this.listData = listData;
    }
    public List<InsurEntity> getList(){
        return  listData;
    }

    public InsurDialog(Context context) {
        super(context, R.style.mall_Dialog);

    }
    public InsurDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected InsurDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        setCustomeDialog();
    }


    public void setDialogCallback(SelectInsurDialog.DialogCallback callback) {
        this.callback = callback;
    }

    private void setCustomeDialog() {

        final List<InsurEntity> list = new ArrayList<InsurEntity>();
        for (int i = 0 ;i<listData.size(); i++){
            InsurEntity insurEntity = new InsurEntity();
            insurEntity.setName(listData.get(i).getName());
            list.add(insurEntity);
        }
        View mView = LayoutInflater.from(getContext()).inflate(R.layout.mall_dialog_selectinsur, null);
        GridView gridView= mView.findViewById(R.id.gridView);
        mAdapter = new InsurGridViewAdapt(getContext(),list);
        gridView.setAdapter(mAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                for(int i = 0;i<list.size();i++){
                    if(position == i){
                        name = list.get(position).getName();
                        list.get(i).setSelect(true);
                    }else{
                        list.get(i).setSelect(false);
                    }
                }
                mAdapter.notifyDataSetChanged();
            }
        });
        Button cancle = (Button) mView.findViewById(R.id.btn_cancel);
        sure = (Button) mView.findViewById(R.id.btn_sure);
        setContentView(mView);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = (int) (DisplayUtil.getScreenWidth(getContext()) * 0.8); //设置宽度
        getWindow().setAttributes(lp);

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsurDialog.this.dismiss();
            }
        });
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onClickRadioButton(name);
            }
        });



    }


    public interface DialogCallback {
        void onClickRadioButton(String name);
    }

}
