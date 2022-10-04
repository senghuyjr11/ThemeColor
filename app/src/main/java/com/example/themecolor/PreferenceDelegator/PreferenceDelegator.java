package com.example.themecolor.PreferenceDelegator;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * PreferenceDelegator
 * <br><br>
 * - 암호화 하여 SharedPreference 에 데이터 저장 <br>
 * - AES 암호화 방식 사용 <br>
 * - App 가 종료되더라도 저장되어야하는 데이터 관리
 *
 * @author Webcash Smart
 * @since 2017. 7. 20.
 **/
public class PreferenceDelegator {

	/** PreferenceDelegator Instance */
	private static PreferenceDelegator mInstance;

	/** AES 암호화 키 */
	private String mRaw = "d40b1465e1838237e5b1abeeac7bec9a";

	String myKey = "";
	byte[] initializationVector;

	/** PreferenceDelegator 에서 데이터를 저장하고 있는 SharedPreferences */
	private SharedPreferences mPreferences;


	/**
	 * 생성자
	 * @param context Context
	 */
	private PreferenceDelegator(Context context) {
		this.mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
	}

	/**
	 * PreferenceDelegator Single Instance 생성, 반환 <br>
	 * @param context Context
	 * @return PreferenceDelegator Single Instance
	 */
	public static PreferenceDelegator getInstance(Context context) {
		if (mInstance == null) {
			mInstance = new PreferenceDelegator(context);
		}
		return mInstance;
	}

	/**
	 * Key 존재 여부 리턴 <br>
	 * @param key Key
	 * @return Key 존재 여부
	 */
	public boolean contains(String key) {
		return this.mPreferences.contains(key);
	}


	/**
	 * Old
	 * - AES 암호화 방식 사용 <br>
	 */
	public String getOld(String key) {
		String returnValue = "";
		try
		{
			if (this.mPreferences.contains(key)) {
				returnValue = this.mPreferences.getString(key, null);

				SecretKeySpec sKeySpec = new SecretKeySpec(this.mRaw.getBytes(), "AES");

				Cipher cipher = Cipher.getInstance("AES");
				cipher.init(2, sKeySpec);
				returnValue = new String(cipher.doFinal(asByte(returnValue)));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return returnValue;
	}


	// TODO :: kkb :: AESUtil 사용방식으로 변경 검토 필요
	/**
	 * Preference KEY 로 저장된 String Data 복호화 하여 리턴
	 * <br><br>
	 * - AES 암호화 방식 사용 <br>
	 * @param key Data Key
	 * @return Key 에 해당하는 복호화된 데이터
	 */
	public String get(String key) {
		String returnValue = "";
		String oldValue = "";
		try
		{
			if (this.mPreferences.contains(key)) {
				returnValue = this.mPreferences.getString(key, null);
				oldValue = this.mPreferences.getString(key, null);

				SecretKeySpec sKeySpec = new SecretKeySpec(this.mRaw.getBytes(), "AES");

				Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
				cipher.init(2, sKeySpec, new IvParameterSpec(IvKey(key)));

				returnValue = new String(cipher.doFinal(asByte(returnValue)));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}

		/**
		 * if there are old encrypt algorithm format (AES)
		 * */
		try {
			if (!TextUtils.isEmpty(oldValue) && !TextUtils.isEmpty(returnValue)){
				if (oldValue.equals(returnValue)){
					String value = getOld(key);
					put(key,value);
					return value;
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return returnValue;
	}

	//get theme
	public int getInt(String key) {
		int returnValue = 0;
		if (this.mPreferences.contains(key)) {
			returnValue = this.mPreferences.getInt(key,0);
			return returnValue;
		}
		return returnValue;
	}


	// TODO :: kkb :: AESUtil 사용방식으로 변경 검토 필요
	/**
	 * Preference 에 해당 KEY-VALUE 로 String Data 암호화 하여 저장
	 * <br><br>
	 * - AES 암호화 방식 사용 <br>
	 * @param key Data Key
	 * @param value 저장할 String Data
	 */
	public void put(String key, String value) {
		try {
			SecretKeySpec sKeySpec = new SecretKeySpec(this.mRaw.getBytes(), "AES");

			Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
			cipher.init(1, sKeySpec, new IvParameterSpec(IvKey(key)));

			value = asHex(cipher.doFinal(value.getBytes()));

			this.mPreferences.edit().putString(key, value).commit();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}
	}

	//set theme
	public void put(String key, int value) {
		this.mPreferences.edit().putInt(key, value).commit();
	}

	/**
	 * Preference 해당 KEY-Data 삭제 <br>
	 * @param key 삭제하고자 하는 Key
	 */
	public void remove(String key) {
		this.mPreferences.edit().remove(key).commit();
	}

	/**
	 * Preference Data 전체 삭제 <br>
	 */
	public void removeAll() {
		this.mPreferences.edit().clear().commit();
	}

	// TODO :: kkb :: HexUtil 사용으로 변경 가능한지 검토 필요
	/**
	 * Hex String > Byte 배열로 변환 <br>
	 * @param s Byte 배열로 변환할 String
	 * @return 변환된 Byte 배열
	 */
	private byte[] asByte(String s) {
		int len = s.length();
		byte[] data = new byte[len % 2 == 0 ? len / 2 : len / 2 + 1];

		for (int i = 0; i < len; i += 2) {
			if (i + 1 < len)
				data[(i / 2)] = ((byte)((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16)));
			else {
				data[(i / 2)] = ((byte)(Character.digit(s.charAt(i), 16) << 4));
			}
		}
		return data;
	}

	// TODO :: kkb :: HexUtil 사용으로 변경 가능한지 검토 필요
	/**
	 * Byte 배열 > Hex String 으로 변환 <br>
	 * @param buf Hex String 으로 변환할 Byte 배열
	 * @return 변환된 Hex String
	 */
	private String asHex(byte[] buf) {
		StringBuffer strbuf = new StringBuffer(buf.length * 2);

		for (int i = 0; i < buf.length; i++) {
			if ((buf[i] & 0xFF) < 16) {
				strbuf.append("0");
			}
			strbuf.append(Long.toString(buf[i] & 0xFF, 16));
		}

		return strbuf.toString();
	}

	// TODO :: IVKey
	/**
	 *initialization vector by cutting key
	 * convert to bytes
	 */
	public byte[] IvKey(String key){
		myKey = key;
		if (key.length()<12){
			int size = 12 - key.length();
			for (int i = 0; i < size; i++) {
				myKey = myKey+i;
			}
			initializationVector = myKey.getBytes();
		}
		else if (key.length() == 12){
			initializationVector = key.getBytes();
		}
		else {
			initializationVector = Arrays.copyOfRange(key.getBytes(), 0,12);
		}
		return initializationVector;
	}
}