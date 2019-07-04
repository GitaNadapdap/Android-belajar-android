package stud11417030.develops.uts2019;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class bookAdapter extends ArrayAdapter<book> {
    private int list_item;

    public bookAdapter(Context context, int resource, ArrayList<book> Book) {
        super(context, resource, Book);
        list_item = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        final book Book = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(list_item, viewGroup, false);
            viewHolder.judulBuku = (TextView) convertView.findViewById(R.id.judulBuku);
            viewHolder.hargaBuku = (TextView) convertView.findViewById(R.id.hargaBuku);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.img);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        viewHolder.judulBuku.setText(Book.getJudul());
        viewHolder.hargaBuku.setText(Book.getHarga());
        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Beli buku "+Book.getJudul()+" di Toko Buku Horasma",Toast.LENGTH_LONG).show();
            }
        });

    return convertView;
    }

    private class ViewHolder{
        public TextView judulBuku;
        public TextView hargaBuku;
        public ImageView img;
    }
}
