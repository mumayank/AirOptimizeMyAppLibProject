package com.mumayank.airoptimizemyapplib

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.air_optimize_my_app_activity.*
import kotlinx.android.synthetic.main.rv_item.view.*
import kotlinx.android.synthetic.main.rv_item_sub.view.*
import mumayank.com.airrecyclerview.AirRv

class AirOptimizeMyAppActivity : AppCompatActivity() {

    companion object {
        const val IS_THEME_LIGHT = "IS_THEME_LIGHT"

        val rvItems = arrayListOf(
            RvItem(
                "OnePlus", arrayListOf(
                    RvItemSub("Open Settings"),
                    RvItemSub("Select Battery"),
                    RvItemSub("Select Battery Optimization"),
                    RvItemSub("Select this app"),
                    RvItemSub("Select Don't Optimize")
                )
            ),
            RvItem(
                "Xiaomi/ Mi/ Redmi", arrayListOf(
                    RvItemSub("Open Security App"),
                    RvItemSub("Select Manage Apps"),
                    RvItemSub("Select this app"),
                    RvItemSub("Enable Autostart"),
                    RvItemSub("Select No Restrictions in Battery Saver")
                )
            ),
            RvItem(
                "Samsung", arrayListOf(
                    RvItemSub("Open Settings > Apps"),
                    RvItemSub("Select Menu (top-right)"),
                    RvItemSub("Select Special Access"),
                    RvItemSub("Select Optimize Battery Usage"),
                    RvItemSub("Turn it off for this app"),
                    RvItemSub("Open Settings > Device Maintenance"),
                    RvItemSub("Select Battery > Scroll to bottom"),
                    RvItemSub("Select Unmonitored Apps"),
                    RvItemSub("Select Add Apps, and add this app")
                )
            ),
            RvItem(
                "Motorola", arrayListOf(
                    RvItemSub("Open Settings"),
                    RvItemSub("Select Battery"),
                    RvItemSub("Select Menu (top-right)"),
                    RvItemSub("Select Battery Optimization"),
                    RvItemSub("Select All Apps from the dropdown"),
                    RvItemSub("Select this app from the list"),
                    RvItemSub("Select Don't Optimize")
                )
            ),
            RvItem(
                "Lenovo", arrayListOf(
                    RvItemSub("Open Settings"),
                    RvItemSub("Select Apps"),
                    RvItemSub("Select this app"),
                    RvItemSub("Select Battery"),
                    RvItemSub("Select Battery Optimization"),
                    RvItemSub("Select Don't Optimize")
                )
            ),
            RvItem(
                "Others", arrayListOf(
                    RvItemSub("These settings are only required if after restarting your phone, the persistent notification of this app doesn't come up automatically. So before proceeding, kindly cross-check if this is true for your phone"),
                    RvItemSub("If the persistent notification isn't coming up automatically after restarting your phone, search for Battery / Battery Optimization settings in your phone and for this app, turn if off (or Don't Optimize)")
                )
            )
        )

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.air_optimize_my_app_activity)
        doneLayout.setOnClickListener {
            finish()
        }

        // set theme
        if (intent.hasExtra(IS_THEME_LIGHT) && intent.getBooleanExtra(IS_THEME_LIGHT, true).not()) {
            ThemeHelper.setTheme(false)
        } else {
            ThemeHelper.setTheme(true)
        }

        // set rv
        AirRv(object : AirRv.Callback {

            override fun aGetAppContext(): Context? {
                return this@AirOptimizeMyAppActivity
            }

            override fun bGetLayoutManager(appContext: Context?): RecyclerView.LayoutManager? {
                return LinearLayoutManager(appContext)
            }

            override fun cGetRvHolderViewGroup(): ViewGroup? {
                return rvHolder
            }

            override fun dGetSize(): Int? {
                return rvItems.size
            }

            override fun eGetViewType(position: Int): Int? {
                return 0
            }

            override fun fGetViewLayoutId(viewType: Int): Int? {
                return R.layout.rv_item
            }

            override fun gGetViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder {
                return CustomViewHolder(view)
            }

            override fun hGetBindView(
                viewHolder: RecyclerView.ViewHolder,
                viewType: Int,
                position: Int
            ) {
                val customViewHolder = viewHolder as CustomViewHolder
                val rvItem = rvItems[position]

                customViewHolder.manufacturerNameTv.text = rvItem.manufacturerName
                defineRvSub(customViewHolder.rvHolderSub, rvItem.rvItemsSub)
            }

        })
    }

    private fun defineRvSub(rvHolderSub: ViewGroup?, rvItemsSub: ArrayList<RvItemSub>) {
        AirRv(object : AirRv.Callback {
            override fun aGetAppContext(): Context? {
                return this@AirOptimizeMyAppActivity
            }

            override fun bGetLayoutManager(appContext: Context?): RecyclerView.LayoutManager? {
                return LinearLayoutManager(appContext)
            }

            override fun cGetRvHolderViewGroup(): ViewGroup? {
                return rvHolderSub
            }

            override fun dGetSize(): Int? {
                return rvItemsSub.size
            }

            override fun eGetViewType(position: Int): Int? {
                return 0
            }

            override fun fGetViewLayoutId(viewType: Int): Int? {
                return R.layout.rv_item_sub
            }

            override fun gGetViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder {
                return CustomViewHolderSub(view)
            }

            override fun hGetBindView(
                viewHolder: RecyclerView.ViewHolder,
                viewType: Int,
                position: Int
            ) {
                val customViewHolderSub = viewHolder as CustomViewHolderSub
                val rvItemSub = rvItemsSub[position]

                customViewHolderSub.idTv.text = "${position + 1}"
                customViewHolderSub.instructionTv.text = rvItemSub.instruction

                if (position == rvItemsSub.size - 1) {
                    customViewHolderSub.verticalLine1.visibility = View.GONE
                    customViewHolderSub.verticalLine2.visibility = View.GONE
                } else {
                    customViewHolderSub.verticalLine1.visibility = View.VISIBLE
                    customViewHolderSub.verticalLine2.visibility = View.VISIBLE
                }
            }

        })
    }

    override fun onBackPressed() {
        val toast =
            Toast.makeText(this, "Please tap on the confirmation to exit", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.BOTTOM or Gravity.CENTER, 0, 300)
        toast.show()
    }

    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val manufacturerNameTv: TextView = view.manufacturerNameTv
        var rvHolderSub: LinearLayout = view.rvHolderSub
    }

    class CustomViewHolderSub(view: View) : RecyclerView.ViewHolder(view) {
        val idTv: TextView = view.idTv
        val instructionTv: TextView = view.instructionTv
        val verticalLine1: LinearLayout = view.verticalLine1
        val verticalLine2: LinearLayout = view.verticalLine2
    }

    class RvItemSub(
        val instruction: String
    )

    class RvItem(
        val manufacturerName: String,
        val rvItemsSub: ArrayList<RvItemSub>
    )
}