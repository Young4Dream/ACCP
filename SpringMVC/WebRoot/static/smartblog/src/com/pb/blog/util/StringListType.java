
package com.pb.blog.util;


import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;


public class StringListType implements  UserType {

    private static final String SPLITTER = "$$$$$";

    private static final int[] TYPES = new int[] { Types.VARCHAR };

    /*
     * (non-Javadoc)
     * 
     * @see org.hibernate.usertype.UserType#sqlTypes()
     */
    public int[] sqlTypes() {
        return TYPES;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hibernate.usertype.UserType#returnedClass()
     */
    @SuppressWarnings("unchecked")
	public Class returnedClass() {
        return List.class;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hibernate.usertype.UserType#equals(java.lang.Object,
     *      java.lang.Object)
     */
    @SuppressWarnings("unchecked")
	public boolean equals(Object one, Object another) throws HibernateException {
        if (one == another)
            return true;
        if (one != null && another != null) {
            List a = (List) one;
            List b = (List) another;
            if (a.size() != b.size())
                return false;
            for (int i = 0; i < a.size(); i++) {
                String str1 = (String) a.get(i);
                String str2 = (String) b.get(i);
                if (!str1.equals(str2))
                    return false;
            }
            return true;
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hibernate.usertype.UserType#hashCode(java.lang.Object)
     */
    public int hashCode(Object arg0) throws HibernateException {
        return 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hibernate.usertype.UserType#nullSafeGet(java.sql.ResultSet,
     *      java.lang.String[], java.lang.Object)
     */
    public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
            throws HibernateException, SQLException {
        String value = (String) Hibernate.STRING.nullSafeGet(rs,names[0]);
        if(value != null){
            return parse(value);
        }
        else{
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hibernate.usertype.UserType#nullSafeSet(java.sql.PreparedStatement,
     *      java.lang.Object, int)
     */
    @SuppressWarnings("unchecked")
	public void nullSafeSet(PreparedStatement pstmt, Object value, int index)
            throws HibernateException, SQLException {
    	if(value!=null){
    		String str = disassemble((List)value);
    		Hibernate.STRING.nullSafeSet(pstmt,str,index);
    	}else{
    		Hibernate.STRING.nullSafeSet(pstmt,value,index);
    	}
    }

    @SuppressWarnings("unchecked")
	public Object deepCopy(Object value) throws HibernateException {
        if (value == null){
            return null;
        }
        List sourceList = (List) value;
        List targetList = new ArrayList();
        targetList.addAll(sourceList);
        return targetList;
    }

    public boolean isMutable() {
        return false;
    }

    @SuppressWarnings("unchecked")
	public String disassemble(List values) throws HibernateException {
    	if(values.isEmpty())
    		return "";
    	StringBuffer sb = new StringBuffer();
    	for(int i=0;i<values.size()-1;i++){
    		sb.append(values.get(i)).append(SPLITTER);
    	}
    	sb.append(values.get(values.size()-1));
        return sb.toString();
    }

    private Object parse(String value){
        String[] strs = StringUtils.split(value,SPLITTER);
        List<String> quotes = new ArrayList<String>();
        for(int i=0; i<strs.length; i++){
            quotes.add(strs[i]);
        }
        return quotes;
    }

	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable)value;
	}

	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return cached;
	}

	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}

}

