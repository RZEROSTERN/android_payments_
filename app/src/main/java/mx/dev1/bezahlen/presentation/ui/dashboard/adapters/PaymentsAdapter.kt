package mx.dev1.bezahlen.presentation.ui.dashboard.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.dev1.bezahlen.core.domain.results.MembershipPaymentsResult
import mx.dev1.bezahlen.R

class PaymentsAdapter(private val items: MutableList<MembershipPaymentsResult>):
    RecyclerView.Adapter<PaymentsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.payment_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var txtAmount = itemView.findViewById<TextView>(R.id.txt_payment_amount)
        var txtId = itemView.findViewById<TextView>(R.id.txt_payment_id)

        fun bind(item: MembershipPaymentsResult) {
            txtId.text = item.id
            txtAmount.text = "$ " + item.amount
        }
    }
}