package com.macrobios.mdcomponents.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.ItemComponentBinding;
import com.macrobios.mdcomponents.utils.Component;

import java.util.List;

public class ComponentAdapter extends RecyclerView.Adapter<ComponentAdapter.ComponentViewHolder> {

    private List<Component> componentList;

    private OnClickListener mListener;
    public interface OnClickListener {
        void onItemClick(Component component);
    }

    public ComponentAdapter(List<Component> componentList) {
        this.componentList = componentList;
    }

    public void setOnClickListener(OnClickListener onClickListener){
        this.mListener = onClickListener;
    }

    @NonNull
    @Override
    public ComponentAdapter.ComponentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //ItemComponentBinding binding = ItemComponentBinding.inflate(LayoutInflater.from(parent.getContext()));
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_component, parent, false);
        return new ComponentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComponentAdapter.ComponentViewHolder holder, int position) {
        Component component = componentList.get(position);
        holder.bind(component);
    }

    @Override
    public int getItemCount() {
        return componentList.size();
    }

    public void add(Component item){
        if (!componentList.contains(item)){
            componentList.add(item);
            notifyItemInserted(componentList.size()-1);
        }
    }

    class ComponentViewHolder extends RecyclerView.ViewHolder {
        private ItemComponentBinding binding;
        private View mView;
        public ComponentViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mView = itemView;
            //this.binding = binding;
        }

        public void bind (Component component){
            Log.d("MC", component.getName() + " " + component.getType());
            TextView txt = mView.findViewById(R.id.txtName);
            ImageView img = mView.findViewById(R.id.imgFoto);

            txt.setText(component.getName());
            img.setImageResource(component.getFotoRes());
            mView.setOnClickListener(v -> {
                mListener.onItemClick(component);
            });
            /*binding.txtName.setText(component.getName());
            binding.imgFoto.setImageResource(component.getFotoRes());
            binding.getRoot().setOnClickListener(v -> {
                mListener.onItemClick(component);
            });
            binding.executePendingBindings();*/
        }
    }
}
