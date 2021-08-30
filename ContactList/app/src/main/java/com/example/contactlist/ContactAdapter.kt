package com.example.contactlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


/*Adapter -> Classe que vai gerenciar a lista
Essa classe vai implementar componentes do RecyclerView e gerenciar toda a lista
ViewHolder -> Responsável por gerenciar cada item da lista


 */
class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>(){

    private val list: MutableList<Contact> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        /*Inflate: para especificar quem é o layout (XML) que vai desenhar cada item na tela*/
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view)
    }

    //Retornar a quantidade de itens da lista
    override fun getItemCount(): Int {
        return list.size
    }

    /*Percorre cada item do array, obtem cada item dele e preenche ele na tela, ou seja, ele vai
    popular o item na lista do RecyclerView
    Cada item que será mostrado passa por esse método
    */
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {

        /*holder é um parâmentro do próprio onBindViewHolder, que é do tipo ContactAdapterViewHolder,
        que é o mesmo da classe ViewHolder e identifica que existe um método chamado bind,
        e que espera um objeto do tipo Contact, que acessado pela lista pela sua posição*/
        holder.bind(list[position])
    }

    /*Método público que acessa o Adapter e que consegue passar a lista aqui pra dentro*/
    fun updateList(List: List<Contact>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }


    /*Criando uma InnerClass (Classe interna da ContactAdpater) que irá implementar o ViewHolder
    do RecyclerView, porém ele espera receber um parâmentro
    Vai ser responsável por gerenciar cada *item* da lista (nome, telefone e imagem).
    Nessa classe irá ficar a declaração de cada item da lista
    */
    class ContactAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val tvName: TextView = itemView.findViewById(R.id.tv_name)
        private val tvPhone: TextView = itemView.findViewById(R.id.tv_phone)
        private val ivPhotograph: ImageView = itemView.findViewById(R.id.iv_photograph)


        /*A função recebe como parâmetro a classe Contact, que é o tipo de cada item da lista,
        ou seja, é um contato*/
        fun bind(contact: Contact){
            tvName.text = contact.name
            tvPhone.text = contact.phone
        }
    }
}