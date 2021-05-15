package com.hc.common.db;

import androidx.room.*

/**
 * date:2021-02-23
 * des:��ʱ��ʾ��demo��entity
 * */

//room���ݿ��ע����,���ݱ�entity  (tableName="db_user",indices = {@Index(value = "uname",unique = true)})

 @Entity(tableName = "db_user",

  // foreignKeys = [ForeignKey(entity = Book::class,parentColumns = ["bid"],childColumns = ["bookId"], onDelete = ForeignKey.SET_DEFAULT)],

    indices = [ Index("uid" , unique = true),Index("bookId", unique = true) ]
 )
class DbUser{

    //ע������ ����ˣ����е�uid�����������Ǵ�����ʱ�򣬲��ø�ֵ,�ڱ���Ĭ������
    @PrimaryKey(autoGenerate = true)
    var uid=0

     //����  ��Ӧ���������� ufname
    @ColumnInfo(name="uname")
    var name:String?=null

    @ColumnInfo(name = "first_name")
    var firstName: String?=null

    @ColumnInfo(name = "last_name")
    var lastName: String?=null


    var city:String?=null

    var age:Int=0

    //������ݱ��в�����@Ignore��ǵ������ֶ�
    @Ignore
    var isSingle = false

    var bookId:Int=0


    @Embedded
    var baby:Child?=null
    override fun toString(): String {
        return "DbUser(uid=$uid, name=$name, firstName=$firstName, lastName=$lastName, city=$city, age=$age, isSingle=$isSingle, bookId=$bookId, baby=$baby)"
    }


}




data class Child(
    val cid: Int,
    val cname: String,
    val cAge: Int,
    val sex: Int
)







//@Entity(//foreignKeys = [
  //  ForeignKey(entity = DbUser::class,parentColumns = ["uid"],childColumns = ["user_id"], onDelete = ForeignKey.SET_DEFAULT),
  //  ForeignKey(entity = Child::class,parentColumns = ["cid"],childColumns = ["childId"], onDelete = ForeignKey.SET_DEFAULT)]
//)
@Entity
data class Book(
    @PrimaryKey
    var bid: Int,
    var name: String,
    var price: Double,

    @ColumnInfo(name = "user_id")
    var userId:Int,
    var childId:Int

)









/**
 * ���ע�⣬��������������sql��ִ�н�����ݣ�������������dao����,����class��Ϊ���ʣ�������data class
 * You can SELECT FROM a DatabaseView similar to an Entity, but you can not INSERT, DELETE or UPDATE into a DatabaseView.
 */

@DatabaseView("select uname,name from db_user,book where uid=3 or bookId=3", viewName = "tempBean")
class TempBean {
    var uname = ""
    var name = ""

    override fun toString(): String {
        return "TempBean(uname='$uname', name='$name')"
    }

}








