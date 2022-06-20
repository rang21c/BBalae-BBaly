package gonghak.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity() {
    private val database : FirebaseDatabase = FirebaseDatabase.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var laundry1_image = findViewById<ImageView>(R.id.laundry1)
        var laundry1_time = findViewById<TextView>(R.id.laundry1_time)
        var laundry1_text = findViewById<TextView>(R.id.laundry1_text)
        var laundry1_warning = findViewById<TextView>(R.id.laundry1_warning)

        var laundry2_image = findViewById<ImageView>(R.id.laundry2)
        var laundry2_time = findViewById<TextView>(R.id.laundry2_time)
        var laundry2_text = findViewById<TextView>(R.id.laundry2_text)
        var laundry2_warning = findViewById<TextView>(R.id.laundry2_warning)

        var dryer1_image = findViewById<ImageView>(R.id.dryer1)
        var dryer1_time = findViewById<TextView>(R.id.dryer1_time)
        var dryer1_text = findViewById<TextView>(R.id.dryer1_text)
        var dryer1_warning = findViewById<TextView>(R.id.dryer1_warning)

        var dryer2_image = findViewById<ImageView>(R.id.dryer2)
        var dryer2_time = findViewById<TextView>(R.id.dryer2_time)
        var dryer2_text = findViewById<TextView>(R.id.dryer2_text)
        var dryer2_warning = findViewById<TextView>(R.id.dryer2_warning)

        val Laundry1 : DatabaseReference = database.getReference("Laundry1")
        Laundry1.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var laundry1_status = snapshot.child("status").value.toString()
                var laundry1_hour = snapshot.child("hour").value.toString()
                var laundry1_minute = snapshot.child("minute").value.toString()
                var end_time = laundry1_hour.toString() + "시 " + laundry1_minute.toString() + "분"
                if (laundry1_status.equals("true")){ // 작동중
                    Glide.with(laundry1_image).load(R.raw.washing2).override(130, 130).into(laundry1_image) // GIF 이미지
                    laundry1_text.setText("세탁 완료 예정 시간")
                    laundry1_time.setText(end_time)
                    laundry1_warning.setText("예상 시간은 실제 시간과 5~15분 차이가 있을 수 있습니다.")
                    Log.e("true", laundry1_status)
                } else { // 작동 X
                    laundry1_image.setImageResource(R.drawable.washer1)
                    laundry1_time.setText("")
                    laundry1_text.setText("세탁기가 작동중이지 않습니다.")
                    laundry1_warning.setText("")
                    Log.e("false", laundry1_status)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        val Laundry2 : DatabaseReference = database.getReference("Laundry2")
        Laundry2.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var laundry2_status = snapshot.child("status").value.toString()
                var laundry2_hour = snapshot.child("hour").value.toString()
                var laundry2_minute = snapshot.child("minute").value.toString()
                var end_time = laundry2_hour.toString() + "시 " + laundry2_minute.toString() + "분"
                if (laundry2_status.equals("true")){ // 작동중
                    Glide.with(laundry2_image).load(R.raw.washing2).override(130, 130).into(laundry2_image) // GIF 이미지
                    laundry2_text.setText("세탁 완료 예정 시간")
                    laundry2_time.setText(end_time)
                    laundry2_warning.setText("예상 시간은 실제 시간과 5~15분 차이가 있을 수 있습니다.")
                    Log.e("true", laundry2_status)
                } else { // 작동 X
                    laundry2_image.setImageResource(R.drawable.washer1)
                    laundry2_time.setText("")
                    laundry2_text.setText("세탁기가 작동중이지 않습니다.")
                    laundry2_warning.setText("")
                    Log.e("false", laundry2_status)
                }
                Log.e("Laundry2 status", laundry2_status)
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        val Dryer1 : DatabaseReference = database.getReference("Dryer1")
        Dryer1.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var Dryer1_status = snapshot.child("status").value.toString()
                var Dryer1_hour = snapshot.child("hour").value.toString()
                var Dryer1_minute = snapshot.child("minute").value.toString()
                var end_time = Dryer1_hour.toString() + "시 " + Dryer1_minute.toString() + "분"
                if (Dryer1_status.equals("true")){ // 작동중
                    Glide.with(dryer1_image).load(R.raw.dry1).override(130, 130).into(dryer1_image) // GIF 이미지
                    dryer1_text.setText("건조 완료 예정 시간")
                    dryer1_time.setText(end_time)
                    dryer1_warning.setText("예상 시간은 실제 시간과 5~15분 차이가 있을 수 있습니다.")
                    Log.e("true", Dryer1_status)
                } else { // 작동 X
                    dryer1_image.setImageResource(R.drawable.dry3)
                    dryer1_time.setText("")
                    dryer1_text.setText("건조기가 작동중이지 않습니다.")
                    dryer1_warning.setText("")
                    Log.e("false", Dryer1_status)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        val Dryer2 : DatabaseReference = database.getReference("Dryer2")
        Dryer2.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var Dryer2_status = snapshot.child("status").value.toString()
                var Dryer2_hour = snapshot.child("hour").value.toString()
                var Dryer2_minute = snapshot.child("minute").value.toString()
                var end_time = Dryer2_hour.toString() + "시 " + Dryer2_minute.toString() + "분"
                if (Dryer2_status.equals("true")){ // 작동중
                    Glide.with(dryer2_image).load(R.raw.dry1).override(130, 130).into(dryer2_image) // GIF 이미지
                    dryer2_text.setText("건조 완료 예정 시간")
                    dryer2_time.setText(end_time)
                    dryer2_warning.setText("예상 시간은 실제 시간과 5~15분 차이가 있을 수 있습니다.")
                    Log.e("true", Dryer2_status)
                } else { // 작동 X
                    dryer2_image.setImageResource(R.drawable.dry3)
                    dryer2_time.setText("")
                    dryer2_text.setText("건조기가 작동중이지 않습니다.")
                    dryer2_warning.setText("")
                    Log.e("false", Dryer2_status)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}