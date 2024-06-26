package com.example.fesenko1.Database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fesenko1.R

class ProductAdapter(
    private var products: List<Product>,
    private val onProductClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    fun setProducts(newProducts: List<Product>) {
        products = newProducts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product, onProductClick)
    }

    override fun getItemCount(): Int = products.size

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val quantityTextView: TextView = itemView.findViewById(R.id.tvQuantity)
        private val priceTextView: TextView = itemView.findViewById(R.id.tvPrice)
        private val yearTextView: TextView = itemView.findViewById(R.id.tvYear)
        private val manufacturerTextView: TextView = itemView.findViewById(R.id.tvManufacturer)

        fun bind(product: Product, onProductClick: (Product) -> Unit) {
            quantityTextView.text = product.quantity.toString()
            priceTextView.text = product.price.toString()
            yearTextView.text = product.year.toString()
            manufacturerTextView.text = product.manufacturer
            itemView.setOnClickListener { onProductClick(product) }
        }
    }
}
