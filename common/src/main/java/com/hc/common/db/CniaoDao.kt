package com.hc.common.db;

import androidx.room.*
import com.hc.common.db.JUser

@Dao
interface  UserDao{

  //查询所有数据，若返回liveData则为 LiveData<List<DbUser>>
    @Query(value = "select * from db_user")
    fun getAll(): List<DbUser?>?

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertBook(book: Book)



/**
 *  表tb_juser插入实体对象JUser
 * */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertJuser(user: JUser)


    @Insert
    fun insertAll(vararg users: DbUser?) //支持可变参数




  /**
   *  查询表里的某个指定的user对象:by  name   age
   * */
  @Query("SELECT * FROM db_user WHERE uname LIKE :name AND age LIKE :age LIMIT 1")
  fun findUserByName(name:String?,age:Int):DbUser



    /**
     * 查询表db_user里的某个指定的user对象:by   uid
     * */
    @Query("select * from db_user where uid like :uid")
    fun getUserByUid(uid: Int): DbUser?


    /**
     * 查询表tb_juser的数据,返回集合
     * */
    @Query("select * from tb_juser")
    fun queryJuser(): List<JUser>

    /**
     *  查询book
     * */
    @Query("select * from book")
     fun getBook(): List<Book>


 /**
  * 删除数据表里指定的某个user对象
  *
 * */
  @Delete
  fun delete(user: DbUser?)


  /**
   * 更新数据库表里某个user对象，若出现冲突，则使用替换策略，还有其他策略可选择
  **/
   @Update(onConflict = OnConflictStrategy.REPLACE)
   fun update(user: DbUser?)


}