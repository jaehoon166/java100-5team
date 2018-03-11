package java100.app.domain;

import java.sql.Date;

public class Cody {
        protected int co_no;
        protected String title;
        protected String conts;
        protected String gender;
        protected Date datetime;
        protected String changetime;
        
        protected int views;
        protected Member writer;
        protected String co_photo;
        protected String wtest;
        protected String h_tag;
        protected int writer_no;
        protected int likedcount;
        protected int top;
        protected int pants;
        
        protected Liked liked;
        

        @Override
        public String toString() {
            return "Cody [co_no=" + co_no + ", title=" + title + ", conts=" + conts + ", gender=" + gender
                    + ", datetime=" + datetime + ", changetime=" + changetime + ", views=" + views + ", writer="
                    + writer + ", co_photo=" + co_photo + ", wtest=" + wtest + ", h_tag=" + h_tag + ", writer_no="
                    + writer_no + ", likedcount=" + likedcount + ", top=" + top + ", pants=" + pants + ", liked="
                    + liked + "]";
        }

        public Liked getLiked() {
            return liked;
        }

        public void setLiked(Liked liked) {
            this.liked = liked;
        }

        public int getCo_no() {
            return co_no;
        }

        public void setCo_no(int co_no) {
            this.co_no = co_no;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getConts() {
            return conts;
        }

        public void setConts(String conts) {
            this.conts = conts;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Date getDatetime() {
            return datetime;
        }

        public void setDatetime(Date datetime) {
            this.datetime = datetime;
        }

        public int getViews() {
            return views;
        }

        public void setViews(int views) {
            this.views = views;
        }

        public Member getWriter() {
            return writer;
        }

        public void setWriter(Member writer) {
            this.writer = writer;
        }

        public String getCo_photo() {
            return co_photo;
        }

        public void setCo_photo(String co_photo) {
            this.co_photo = co_photo;
        }

        public String getWtest() {
            return wtest;
        }

        public void setWtest(String wtest) {
            this.wtest = wtest;
        }

        public int getWriter_no() {
            return writer_no;
        }

        public void setWriter_no(int writer_no) {
            this.writer_no = writer_no;
        }

        public int getLikedcount() {
            return likedcount;
        }

        public void setLikedcount(int likedcount) {
            this.likedcount = likedcount;
        }

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public int getPants() {
            return pants;
        }

        public void setPants(int pants) {
            this.pants = pants;
        }

        public String getChangetime() {
            return changetime;
        }

        public void setChangetime(String changetime) {
            this.changetime = changetime;
        }

        public String getH_tag() {
            return h_tag;
        }

        public void setHtag(String h_tag) {
            this.h_tag = h_tag;
        }

        
        
        }

        
