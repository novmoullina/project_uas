package com.noviam.project_uas


    import android.content.Intent
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.ImageView
    import android.widget.RelativeLayout
    import android.widget.TextView
    import android.widget.Toast
    import androidx.recyclerview.widget.RecyclerView
    import com.bumptech.glide.Glide
    import com.bumptech.glide.request.RequestOptions
    import kotlinx.android.synthetic.main.detailkuliner.view.*


    class objectrecycleradapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        private  var items: List<listObject> = ArrayList()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return objectViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.detailkuliner, parent, false)
            )
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when(holder) {
                is objectViewHolder -> {
                    holder.bind(items.get(position))
                    holder.klik.setOnClickListener {
                        holder.kalau_diklik(items.get(position))
                    }
                }
            }
        }
        fun submitList(listDosen: List<listObject>){
            items = listDosen
        }

        override fun getItemCount(): Int {
            return items.size
        }

        class objectViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val nama : TextView = itemView.nama
           val keterangan : TextView = itemView.keterangan

            fun bind(listObjDosen: listObject) {
                nama.setText(listObjDosen.nama)
                keterangan.setText(listObjDosen.keterangan)


                val requestOp = RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)


            }
            fun kalau_diklik(get: listObject) {
                val position:Int = adapterPosition
                Toast.makeText(itemView.context, "Kamu memilih : ${get.nama}",
                    Toast.LENGTH_SHORT)
                    .show()

                val intent =Intent(itemView.context, DetilResep::class.java)
                intent.putExtra("namanya", get.nama)
                intent.putExtra("keterangannya", get.keterangan)
                itemView.context.startActivity(intent)
            }
        }
    }
