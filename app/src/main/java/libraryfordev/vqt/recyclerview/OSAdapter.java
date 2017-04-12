package libraryfordev.vqt.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by vothanhquang on 4/4/17.
 */

public class OSAdapter extends RecyclerView.Adapter<OSAdapter.ViewHolder> {
    ArrayList<OS> alOS;
    Context context;

    public OSAdapter(ArrayList<OS> alOS, Context context) {
        this.alOS = alOS;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_child, parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtOS.setText(alOS.get(position).name);
        holder.imgOS.setImageResource(alOS.get(position).hinh);
    }

    public void removedItems(int position) {
        alOS.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return alOS.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtOS;
        ImageView imgOS;
        public ViewHolder(View itemView) {
            super(itemView);
            txtOS = (TextView)itemView.findViewById(R.id.textView_OS);
            imgOS = (ImageView)itemView.findViewById(R.id.imageView_OS);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   try {
                       removedItems(getAdapterPosition());
                   } catch (Exception e) {

                   }

                }
            });
        }
    }
}
