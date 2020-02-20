Java.perform(function () {
    //普通方法hook
    var FUNCTION_NAME1 = Java.use('ANDROID_PROCESS_NAME.FUNCTION_NAME1');
    FUNCTION_NAME1.getCalc.implementation = function (a,b) {
        send("Hook Start...");
        send("A:"+a);
        send("B:"+b);
        var origin = this.getCalc(a,b);
        send("未Hook的原始结果:"+origin);
        var a    = 100;
        var b    = 200;
        var c    = 300;     
        var res  = this._getCalc(a,b,c)
        send("普通方法Hook成功");
        send("Hook成功后的的结果:"+res);
        return this._getCalc(a,b,c);

    }
    //构造方法hook
    var FUNCTION_NAME2 = Java.use('ANDROID_PROCESS_NAME.FUNCTION_NAME2');
    FUNCTION_NAME2.$init.implementation = function (a,b) {
        send("Hook Start...");
        send("A:"+a);
        send("B:"+b);
        var origin  = a  + b;
        send("未Hook的原始结果:"+origin);
        send("构造方法Hook成功");
        var res  = 10000 + " 美元";
        send("Hook成功后的的结果:"+res);
        return this.$init(10000,"美元");

    }
    //重载方法hook
    var FUNCTION_NAME1 = Java.use('ANDROID_PROCESS_NAME.FUNCTION_NAME1');
    FUNCTION_NAME1.test.overload("int").implementation = function (a) {
        send("Hook Start...");
        var origin = "QAX:1234"
        send("未Hook的原始结果:"+origin);
        send("构造方法Hook成功");
        var res  = this.test(10000)
        send("Hook成功后的的结果:"+res);
        return this.test(10000);

    }


});
