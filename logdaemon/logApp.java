void sendonemsg()
    {
		DatagramSocket s;
		try {
			s = new DatagramSocket();
			InetAddress local = InetAddress.getByName("127.0.0.1");
			String str="hello service";
			int msg_length = str.length();
			DatagramPacket p = new DatagramPacket(str.getBytes(), msg_length, local, 2000);
			s.send(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
