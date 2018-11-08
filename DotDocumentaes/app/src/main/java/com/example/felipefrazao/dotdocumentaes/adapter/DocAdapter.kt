package com.example.felipefrazao.dotdocumentaes.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.felipefrazao.dotdocumentaes.PdfActivity
import com.example.felipefrazao.dotdocumentaes.R
import com.example.felipefrazao.dotdocumentaes.domain.Doc

class DocAdapter(
        private val context:Context,
        private val docList:List<Doc>):RecyclerView.Adapter<DocAdapter.ViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.iten_doc,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return docList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(docList[position])
    }


    inner class ViewHolder(itenView: View):RecyclerView.ViewHolder(itenView), View.OnClickListener {


        val ivCover: ImageView
        val tvlanguages: TextView
        val tvtotalPages: TextView
        val tvPageStopped: TextView

        init {
            itenView.setOnClickListener(this)
            ivCover = itenView.findViewById(R.id.iv_cover)
            tvlanguages = itenView.findViewById(R.id.tv_language)
            tvtotalPages = itenView.findViewById(R.id.tv_total_pages)
            tvPageStopped = itenView.findViewById(R.id.tv_page_stopped)
        }

        fun setData(doc: Doc){
            ivCover.setImageResource(doc.imageRes)
            tvtotalPages.text = "${doc.pagesNumber} páginas"
            tvlanguages.text = doc.language

            tvPageStopped.visibility = if(doc.getActualPage(context,1) > 1 ){
                tvPageStopped.text = "Parou na página ${doc.getActualPage(context,1).toString()}"
                View.VISIBLE
            }else{
                View.GONE
            }

        }

        override fun onClick(v: View?) {
            val intente = Intent(context, PdfActivity::class.java )
            intente.putExtra(Doc.DOC_KEY, docList.get(adapterPosition))
            context.startActivity(intente)
        }

    }
}