package com.martin.xposed;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * <p>
 * Package Name:com.martin.xposed
 * </p>
 * <p>
 * Class Name:HookMain
 * <p>
 * Description:Hook的入口
 * </p>
 *
 * @Author Martin
 * @Version 1.0 2019/1/29 2:38 PM Release
 * @Reviser:
 * @Modification Time:2019/1/29 2:38 PM
 */
public class HookMain implements IXposedHookLoadPackage {

    /**
     * XposedBridge.log()：以原生logcat的形式写入到/data/user_de/0/de.robv.android.xposed.installer/log/error.log
     */
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (loadPackageParam.packageName.equals(BuildConfig.APPLICATION_ID)) {
            Class clazz = loadPackageParam.classLoader.loadClass("com.martin.xposed.MainActivity");
            XposedHelpers.findAndHookMethod(clazz, "toastMessage", new XC_MethodHook() {
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    XposedBridge.log("Hook成功");
                }

                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult("按钮已被劫持");
                }
            });
        }
    }

}
