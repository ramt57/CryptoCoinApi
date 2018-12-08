package com.greatest.ram.bitcoinapi.utils.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.greatest.ram.bitcoinapi.utils.R;
import com.greatest.ram.bitcoinapi.utils.activity.DetailActivity;
import com.greatest.ram.bitcoinapi.utils.model.Datum;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    static List<Datum> datumList;
    public RecyclerAdapter(List<Datum> data){
        datumList=data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_coin,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Datum datum=datumList.get(position);
        holder.symbol.setText(datum.getmSymbol()+"");
        holder.name.setText(datum.getmName()+"");
        holder.price.setText(datum.getmQuote().mINR.getmPriceINR()+"");
    }

    @Override
    public int getItemCount() {
        return datumList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView symbol,name,price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            symbol=itemView.findViewById(R.id.symbol);
            name=itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.amount);
            itemView.setOnClickListener(view -> {
                Intent intent=new Intent(itemView.getContext(),DetailActivity.class);
                intent.putExtra("ID",datumList.get(getAdapterPosition()).mId);
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
