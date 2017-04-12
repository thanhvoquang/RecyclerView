package libraryfordev.vqt.recyclerview;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        XuLy();
    }
    public void XuLy() {
        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.recyclerView);
        //cho phep kich thuoc cua recycleview tu can chinh theo kich thuoc phu hop
        recyclerView.setHasFixedSize(true);
        // dieu chinh cac hien thi cac item con nam trong recycleview la dang vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        // duong phan cach giua cac itemcon mac dinh
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,linearLayoutManager.getOrientation());
//        recyclerView.addItemDecoration(dividerItemDecoration);
        //custom duong phan cach giua cac itemcon
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.line);
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(dividerItemDecoration);

//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //nap du lieu vao cho arrayList
        ArrayList<OS> alOS = new ArrayList<>();
        alOS.add(new OS("Window Mobile",R.drawable.cmyk));
        alOS.add(new OS("Android",R.drawable.edittools));
        alOS.add(new OS("iOS",R.drawable.programming));
        //truyen du lieu vao ham tao cua Adapter
        OSAdapter os = new OSAdapter(alOS, this);
        //set adapter cho recycleview
        recyclerView.setAdapter(os);
    }
}
