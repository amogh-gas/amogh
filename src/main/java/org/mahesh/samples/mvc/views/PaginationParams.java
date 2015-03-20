package org.mahesh.samples.mvc.views;

import java.io.Serializable;

/**
 * The Class PaginationParams.
 */
public class PaginationParams implements Serializable {

   /** The Constant serialVersionUID. */
   private static final long serialVersionUID = 1L;

   /** The sortdatafield. */
   private String sortdatafield;

   /** The sortorder. */
   private String sortorder;

   /** The pagenum. */
   private Long pagenum;

   /** The pagesize. */
   private Long pagesize;

   /** The groupscount. */
   private Long groupscount;

   /** The group. */
   private String group;

   /** The filterscount. */
   private Long filterscount;

   /** The filtervalue. */
   private String filtervalue;

   /** The filtercondition. */
   private String filtercondition;

   /** The filterdatafield. */
   private String filterdatafield;

   /** The filteroperator. */
   private String filteroperator;

   /** The recordstartindex. */
   private Long recordstartindex;

   /** The recordendindex. */
   private Long recordendindex;

   /** The rows. */
   private Object rows;

   /** The total rows. */
   private Long totalRows;

   /** The first row. */
   private Long firstRow;

   /** The last row. */
   private Long lastRow;

   /** The uid. */
   private Long uid;

   /**
    * Gets the first row.
    * 
    * @return the first row
    */
   public Long getFirstRow()
   {
      return firstRow;
   }

   /**
    * Sets the first row.
    * 
    * @param firstRow
    *           the new first row
    */
   public void setFirstRow(Long firstRow)
   {
      this.firstRow = firstRow;
   }

   /**
    * Gets the last row.
    * 
    * @return the last row
    */
   public Long getLastRow()
   {
      return lastRow;
   }

   /**
    * Sets the last row.
    * 
    * @param lastRow
    *           the new last row
    */
   public void setLastRow(Long lastRow)
   {
      this.lastRow = lastRow;
   }

   /**
    * Gets the sortdatafield.
    * 
    * @return the sortdatafield
    */
   public String getSortdatafield()
   {
      return sortdatafield;
   }

   /**
    * Sets the sortdatafield.
    * 
    * @param sortdatafield
    *           the new sortdatafield
    */
   public void setSortdatafield(String sortdatafield)
   {
      this.sortdatafield = sortdatafield;
   }

   /**
    * Gets the sortorder.
    * 
    * @return the sortorder
    */
   public String getSortorder()
   {
      return sortorder;
   }

   /**
    * Sets the sortorder.
    * 
    * @param sortorder
    *           the new sortorder
    */
   public void setSortorder(String sortorder)
   {
      this.sortorder = sortorder;
   }

   /**
    * Gets the pagenum.
    * 
    * @return the pagenum
    */
   public Long getPagenum()
   {
      return pagenum;
   }

   /**
    * Sets the pagenum.
    * 
    * @param pagenum
    *           the new pagenum
    */
   public void setPagenum(Long pagenum)
   {
      this.pagenum = pagenum;
   }

   /**
    * Gets the pagesize.
    * 
    * @return the pagesize
    */
   public Long getPagesize()
   {
      return pagesize;
   }

   /**
    * Sets the pagesize.
    * 
    * @param pagesize
    *           the new pagesize
    */
   public void setPagesize(Long pagesize)
   {
      this.pagesize = pagesize;
   }

   /**
    * Gets the groupscount.
    * 
    * @return the groupscount
    */
   public Long getGroupscount()
   {
      return groupscount;
   }

   /**
    * Sets the groupscount.
    * 
    * @param groupscount
    *           the new groupscount
    */
   public void setGroupscount(Long groupscount)
   {
      this.groupscount = groupscount;
   }

   /**
    * Gets the group.
    * 
    * @return the group
    */
   public String getGroup()
   {
      return group;
   }

   /**
    * Sets the group.
    * 
    * @param group
    *           the new group
    */
   public void setGroup(String group)
   {
      this.group = group;
   }

   /**
    * Gets the filterscount.
    * 
    * @return the filterscount
    */
   public Long getFilterscount()
   {
      return filterscount;
   }

   /**
    * Sets the filterscount.
    * 
    * @param filterscount
    *           the new filterscount
    */
   public void setFilterscount(Long filterscount)
   {
      this.filterscount = filterscount;
   }

   /**
    * Gets the filtervalue.
    * 
    * @return the filtervalue
    */
   public String getFiltervalue()
   {
      return filtervalue;
   }

   /**
    * Sets the filtervalue.
    * 
    * @param filtervalue
    *           the new filtervalue
    */
   public void setFiltervalue(String filtervalue)
   {
      this.filtervalue = filtervalue;
   }

   /**
    * Gets the filtercondition.
    * 
    * @return the filtercondition
    */
   public String getFiltercondition()
   {
      return filtercondition;
   }

   /**
    * Sets the filtercondition.
    * 
    * @param filtercondition
    *           the new filtercondition
    */
   public void setFiltercondition(String filtercondition)
   {
      this.filtercondition = filtercondition;
   }

   /**
    * Gets the filterdatafield.
    * 
    * @return the filterdatafield
    */
   public String getFilterdatafield()
   {
      return filterdatafield;
   }

   /**
    * Sets the filterdatafield.
    * 
    * @param filterdatafield
    *           the new filterdatafield
    */
   public void setFilterdatafield(String filterdatafield)
   {
      this.filterdatafield = filterdatafield;
   }

   /**
    * Gets the filteroperator.
    * 
    * @return the filteroperator
    */
   public String getFilteroperator()
   {
      return filteroperator;
   }

   /**
    * Sets the filteroperator.
    * 
    * @param filteroperator
    *           the new filteroperator
    */
   public void setFilteroperator(String filteroperator)
   {
      this.filteroperator = filteroperator;
   }

   /**
    * Gets the recordstartindex.
    * 
    * @return the recordstartindex
    */
   public Long getRecordstartindex()
   {
      return recordstartindex;
   }

   /**
    * Sets the recordstartindex.
    * 
    * @param recordstartindex
    *           the new recordstartindex
    */
   public void setRecordstartindex(Long recordstartindex)
   {
      this.recordstartindex = recordstartindex;
   }

   /**
    * Gets the recordendindex.
    * 
    * @return the recordendindex
    */
   public Long getRecordendindex()
   {
      return recordendindex;
   }

   /**
    * Sets the recordendindex.
    * 
    * @param recordendindex
    *           the new recordendindex
    */
   public void setRecordendindex(Long recordendindex)
   {
      this.recordendindex = recordendindex;
   }

   /**
    * Gets the rows.
    * 
    * @return the rows
    */
   public Object getRows()
   {
      return rows;
   }

   /**
    * Sets the rows.
    * 
    * @param rows
    *           the new rows
    */
   public void setRows(Object rows)
   {
      this.rows = rows;
   }

   /**
    * Gets the total rows.
    * 
    * @return the total rows
    */
   public Long getTotalRows()
   {
      return totalRows;
   }

   /**
    * Sets the total rows.
    * 
    * @param totalRows
    *           the new total rows
    */
   public void setTotalRows(Long totalRows)
   {
      this.totalRows = totalRows;
   }

   /**
    * Gets the uid.
    * 
    * @return the uid
    */
   public Long getUid()
   {
      return uid;
   }

   /**
    * Sets the uid.
    * 
    * @param uid
    *           the new uid
    */
   public void setUid(Long uid)
   {
      this.uid = uid;
   }
}
