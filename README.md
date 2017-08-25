# Location
基于android源生的组件


## LLocation使用方法

由于是后台定位，需要现在清单文件中声明服务和定位权限。

	     <service android:name="com.example.llocation.MyService" />
        <service android:name="com.example.llocation.YourService" />

之后进行初始化
		
		//初始化，传入activity,会先判断是否有权限，如果没有，需要先获得允许
		LLocationManager lLocationManager = new LLocationManager(this);
		//设置每次定位的间隔时间，单位为s，默认为10s
        lLocationManager.setTime(10);
		//设置每次定位的位置距离,单位为米，默认为10m 
		//当时间间隔和位置距离都设置时，以位置距离间隔定位，若一方为0，则以另一方间隔标准定位。
        lLocationManager.setDistance(10);
		//定位模式，分为MyLocation.GPS和MyLocation.NETWORK
        lLocationManager.setType(MyLocation.GPS);
		//定位状态的接口，分为开始，结束，失败，暂停，成功
        lLocationManager.setListener(new LLocation() {
            @Override
            public void OnSuccess(LocationData locationData) {
				//成功时返回Type(定位模式),location(经纬度等信息),Statellites（定位时的卫星个数）
                Log.e(TAG, "OnSuccess: " + locationData.toString());
            }
			//失败时返回错误码
			//556：没有定位权限
			//697：没有足够的卫星支持定位
			//491：定位失败
			//387：定位服务不在服务区
            @Override
            public void OnFailed(int error) {
                Log.e(TAG, "OnFailed: " + error);
            }
        });
		//开启后台服务
        lLocationManager.startService();
