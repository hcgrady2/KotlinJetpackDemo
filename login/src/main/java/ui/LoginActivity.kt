package login.ui

import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ToastUtils
import com.hc.common.base.BaseActivity
import com.hc.common.ktx.context
import com.hc.common.network.config.SP_KEY_USER_TOKEN
import com.hc.common.utils.MySpUtils
import com.hc.kotlinjetpackdemo.login.R
import com.hc.kotlinjetpackdemo.login.databinding.ActivityLoginBinding
import com.hc.login.LoginViewModel
import com.hc.login.net.RegisterRsp
import com.hc.service.repo.DbHelper
import org.koin.androidx.viewmodel.ext.android.viewModel

//路由地址
@Route(path = "/login/login")
class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    //这是 koin 里面的，因此需要初始化 koin
    private val viewModel: LoginViewModel by viewModel()

    override fun getLayoutRes() = R.layout.activity_login

    override fun initView() {
        super.initView()

        mBinding.apply {
            vm = viewModel
            //左上角退出按钮点击事件
            mtoolbarLogin.setNavigationOnClickListener {
                finish() }
            //注册新账号按钮点击事件
            tvRegisterLogin.setOnClickListener {
                ToastUtils.showShort("当前课程项目为实现注册账号功能")
            }

        }

    }

    override fun initConfig() {
        super.initConfig()

        //在UI里观察两个请求的返回结果
        viewModel.apply {


            //扩展函数
            liveRegisterRsp.observerKt {
                if (it?.is_register == RegisterRsp.FLAG_IS_REGISTERED) {
                    repoLogin() //登录请求
                }
            }


            liveLoginRsp.observerKt {
                it.also {
                    //将数据保存到数据库里
                    it?.let { DbHelper.insertUserInfo(context, it) }
                    //保存token值
                    MySpUtils.put(SP_KEY_USER_TOKEN, it?.token)
                }
                //关闭Activity
                finish()
            }


        }

    }


}