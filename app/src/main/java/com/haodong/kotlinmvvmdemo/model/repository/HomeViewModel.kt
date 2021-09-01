package com.haodong.kotlinmvvmdemo.model.repository

import com.haodong.lib.common.core.BaseViewModel
import com.haodong.lib.common.model.DTOResult
import com.haodong.lib.common.model.bean.ArticleList
import com.haodong.lib.common.model.bean.Banner
import com.kunminx.architecture.ui.callback.UnPeekLiveData
import kotlinx.coroutines.flow.collect

/**
 * Author: tangyuan
 * Time : 2021/8/19
 * Description:
 */
class HomeViewModel : BaseViewModel() {
    val repository = HomeRepository()
    val articleState = UnPeekLiveData<BaseUiModel<ArticleList>>()
    val bannerState = UnPeekLiveData<DTOResult<List<Banner>>>()

    fun getArticleList(page: Int, isRefresh: Boolean) {
        launchOnUI {
            repository.getArticleList(page, isRefresh).collect {
                articleState.postValue(it)
            }
        }
    }

    fun getbanner() {
        launchOnUI {
            repository.getBanners().collect {
                bannerState.postValue(it)
            }
        }
    }
    fun collectArticle(articleId:Int,boolean: Boolean){
        launchOnUI {
            if (boolean){
                repository.collectArticle(articleId).collect {  }
            }else{
                repository.unCollectArticle(articleId)
            }
        }
    }

}