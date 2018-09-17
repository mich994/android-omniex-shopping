package nl.omniex.omniexshopping.ui.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter<T, V extends View> extends RecyclerView.Adapter<BaseRecyclerAdapter.ViewWrapper<V>> {

    private List<T> mItems = new ArrayList<>();
    private ItemClickListener<T> mItemClickListener;
    private OnBottomReachedListener mOnBottomReachedListener;

    @NonNull
    @Override
    public ViewWrapper<V> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewWrapper<>(onCreateItemView(parent, viewType));
    }

    protected abstract V onCreateItemView(ViewGroup parent, int viewType);

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public List<T> getItems() {
        return mItems;
    }

    public T getItem(int position) {
        if (position > -1 && position < mItems.size()) {
            return mItems.get(position);
        }
        return null;
    }

    public void setItems(List<T> items) {
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    public void addItems(List<T> items) {
        mItems.addAll(items);
        notifyItemRangeChanged(mItems.size() - items.size(), mItems.size());
    }

    public void addItem(T item) {
        mItems.add(item);
        notifyItemInserted(mItems.size());
    }

    public void removeItem(int position) {
        mItems.remove(position);
        notifyDataSetChanged();
    }

    public void removeItem(T item) {
        int removedIndex = mItems.indexOf(item);
        mItems.remove(item);
        notifyDataSetChanged();
    }

    public int getPosition(T item) {
        return mItems.indexOf(item);
    }

    public void setItemClickListener(ItemClickListener<T> itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public ItemClickListener<T> getItemClickListener() {
        return mItemClickListener;
    }

    public void setOnBottomReachedListener(OnBottomReachedListener onBottomReachedListener) {
        mOnBottomReachedListener = onBottomReachedListener;
    }

    public OnBottomReachedListener getOnBottomReachedListener() {
        return mOnBottomReachedListener;
    }

    public static class ViewWrapper<V extends View> extends RecyclerView.ViewHolder {

        private V mView;

        protected ViewWrapper(V itemView) {
            super(itemView);
            mView = itemView;
        }

        public V getView() {
            return mView;
        }
    }

    public interface ItemClickListener<Model> {
        void onItemClick(Model model);
    }

    public interface OnBottomReachedListener {
        void onBottomReached();
    }

}
