package auto.mod.ext

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import auto.mod.plugin.Plugin
import top.canyie.pine.Pine
import top.canyie.pine.callback.MethodHook

class ExtPlugin : Plugin() {
    override fun load(context: Context) {
        Log.e("AUTOMOD", "Ext Test")
        android.widget.Toast.makeText(context, "Ext Test", 5).show()
        Pine.hook(Activity::class.java.getDeclaredMethod("onCreate", Bundle::class.javaObjectType), object : MethodHook() {
            override fun beforeCall(callFrame: Pine.CallFrame) {
                Log.e("AUTOMOD", "Before " + callFrame.thisObject + " onCreate()")
            }

            override fun afterCall(callFrame: Pine.CallFrame) {
                Log.e("AUTOMOD", "After " + callFrame.thisObject + " onCreate()")
            }
        })
    }
}
