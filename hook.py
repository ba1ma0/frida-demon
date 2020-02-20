# -- coding: utf-8 --
import frida, sys , os 
ANDROID_PROCESS_NAME    = "com.example.frida" #需要hook的android进程名
FUNCTION_NAME1          = "Utils"             #需要hook的函数
FUNCTION_NAME2          = "Money"             #需要hook的函数
current_dir             = os.getcwd()         #获取当前路径
jscode_file_path  		= os.path.join(current_dir,'jscode.js') 
jscode_file             = open(jscode_file_path,"r")
jscode                  = jscode_file.read()
jscode                  =jscode.replace("ANDROID_PROCESS_NAME",ANDROID_PROCESS_NAME)
jscode                  =jscode.replace("FUNCTION_NAME1",FUNCTION_NAME1)
jscode                  =jscode.replace("FUNCTION_NAME2",FUNCTION_NAME2)


def on_message(message, data):
    if message['type'] == 'send':
        print("[*] {0}".format(message['payload']))
    else:
        print(message)


process = frida.get_usb_device().attach(ANDROID_PROCESS_NAME)
script = process.create_script(jscode)
script.on('message', on_message)
script.load()
sys.stdin.read()
