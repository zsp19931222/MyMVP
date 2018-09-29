package util;

import android.view.View;
import android.widget.EditText;

/**
 * Created by Administrator on 2018/9/29 0029.
 */

public class ClearUtil implements View.OnClickListener {
    private View view;
    private EditText editText;

    public ClearUtil(View view, EditText editText) {
        this.view = view;
        this.editText = editText;
        view.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        editText.setText("");
    }
}
