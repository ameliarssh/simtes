/*
  Dilarang keras menggandakan/mengcopy/menyebarkan/membajak/mendecompile 
  Software ini dalam bentuk apapun tanpa seijin pembuat software
  (Khanza.Soft Media). Bagi yang sengaja membajak softaware ini ta
  npa ijin, kami sumpahi sial 1000 turunan, miskin sampai 500 turu
  nan. Selalu mendapat kecelakaan sampai 400 turunan. Anak pertama
  nya cacat tidak punya kaki sampai 300 turunan. Susah cari jodoh
  sampai umur 50 tahun sampai 200 turunan. Ya Alloh maafkan kami 
  karena telah berdoa buruk, semua ini kami lakukan karena kami ti
  dak pernah rela karya kami dibajak tanpa ijin.
 */

package inventory;

import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.akses;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author dosen
 */
public final class DlgReturObatPasien extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private sekuel Sequel=new sekuel();
    private Connection koneksi=koneksiDB.condb();
    private riwayatobat Trackobat=new riwayatobat();
    private final validasi Valid=new validasi();
    private PreparedStatement pstampil;
    private ResultSet rstampil;
    private String aktifkanbatch="no";
    /** Creates new form DlgPenyakit
     * @param parent
     * @param modal */
    public DlgReturObatPasien(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocation(10,2);
        setSize(628,674);

        tabMode=new DefaultTableModel(null,new Object[]{"Tanggal Retur","No.Rawat","Pasien","Barang","Jml.Retur","Kode Barang","Asal Stok","No.Batch","No.Faktur"}){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        tbKamar.setModel(tabMode);
        //tbPenyakit.setDefaultRenderer(Object.class, new WarnaTable(panelJudul.getBackground(),tbPenyakit.getBackground()));
        tbKamar.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbKamar.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < 9; i++) {
            TableColumn column = tbKamar.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(100);
            }else if(i==1){
                column.setPreferredWidth(120);
            }else if(i==2){
                column.setPreferredWidth(200);
            }else if(i==3){
                column.setPreferredWidth(200);
            }else if(i==4){
                column.setPreferredWidth(70);
            }else if(i==5){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==6){
                //column.setMinWidth(0);
                //column.setMaxWidth(0);
            }else if(i==7){
                column.setPreferredWidth(70);
            }else if(i==8){
                column.setPreferredWidth(100);
            }
        }
        tbKamar.setDefaultRenderer(Object.class, new WarnaTable());
                
        TCari.setDocument(new batasInput((byte)100).getKata(TCari));                
        if(koneksiDB.CARICEPAT().equals("aktif")){
            TCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){
                @Override
                public void insertUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
                @Override
                public void removeUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
                @Override
                public void changedUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
            });
        } 
        
        try {
            aktifkanbatch = koneksiDB.AKTIFKANBATCHOBAT();
        } catch (Exception e) {
            System.out.println("E : "+e);
            aktifkanbatch = "no";
        }
    } 


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Kd2 = new widget.TextBox();
        internalFrame1 = new widget.InternalFrame();
        Scroll = new widget.ScrollPane();
        tbKamar = new widget.Table();
        jPanel1 = new javax.swing.JPanel();
        panelisi3 = new widget.panelisi();
        label11 = new widget.Label();
        Tgl1 = new widget.Tanggal();
        label19 = new widget.Label();
        Tgl2 = new widget.Tanggal();
        label9 = new widget.Label();
        TCari = new widget.TextBox();
        BtnAll = new widget.Button();
        BtnCari = new widget.Button();
        panelisi1 = new widget.panelisi();
        BtnHapus = new widget.Button();
        BtnPrint = new widget.Button();
        label10 = new widget.Label();
        LCount = new widget.Label();
        BtnKeluar = new widget.Button();

        Kd2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Kd2.setHighlighter(null);
        Kd2.setName("Kd2"); // NOI18N
        Kd2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Kd2KeyPressed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Retur Obat, Alkes & BHP Medis Pasien ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50,50,50))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);

        tbKamar.setAutoCreateRowSorter(true);
        tbKamar.setName("tbKamar"); // NOI18N
        Scroll.setViewportView(tbKamar);

        internalFrame1.add(Scroll, java.awt.BorderLayout.CENTER);

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(816, 100));
        jPanel1.setLayout(new java.awt.BorderLayout(1, 1));

        panelisi3.setName("panelisi3"); // NOI18N
        panelisi3.setPreferredSize(new java.awt.Dimension(100, 44));
        panelisi3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 4, 9));

        label11.setText("Tanggal :");
        label11.setName("label11"); // NOI18N
        label11.setPreferredSize(new java.awt.Dimension(60, 23));
        panelisi3.add(label11);

        Tgl1.setDisplayFormat("dd-MM-yyyy");
        Tgl1.setName("Tgl1"); // NOI18N
        Tgl1.setPreferredSize(new java.awt.Dimension(95, 23));
        panelisi3.add(Tgl1);

        label19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label19.setText("s.d.");
        label19.setName("label19"); // NOI18N
        label19.setPreferredSize(new java.awt.Dimension(30, 23));
        panelisi3.add(label19);

        Tgl2.setDisplayFormat("dd-MM-yyyy");
        Tgl2.setName("Tgl2"); // NOI18N
        Tgl2.setPreferredSize(new java.awt.Dimension(95, 23));
        panelisi3.add(Tgl2);

        label9.setText("Key Word :");
        label9.setName("label9"); // NOI18N
        label9.setPreferredSize(new java.awt.Dimension(90, 23));
        panelisi3.add(label9);

        TCari.setName("TCari"); // NOI18N
        TCari.setPreferredSize(new java.awt.Dimension(250, 23));
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelisi3.add(TCari);

        BtnAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        BtnAll.setMnemonic('3');
        BtnAll.setToolTipText("Alt+3");
        BtnAll.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnAll.setName("BtnAll"); // NOI18N
        BtnAll.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAllActionPerformed(evt);
            }
        });
        BtnAll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnAllKeyPressed(evt);
            }
        });
        panelisi3.add(BtnAll);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('2');
        BtnCari.setToolTipText("Alt+2");
        BtnCari.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnCari.setName("BtnCari"); // NOI18N
        BtnCari.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });
        BtnCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCariKeyPressed(evt);
            }
        });
        panelisi3.add(BtnCari);

        jPanel1.add(panelisi3, java.awt.BorderLayout.PAGE_START);

        panelisi1.setName("panelisi1"); // NOI18N
        panelisi1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        BtnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/stop_f2.png"))); // NOI18N
        BtnHapus.setMnemonic('H');
        BtnHapus.setText("Hapus");
        BtnHapus.setToolTipText("Alt+H");
        BtnHapus.setName("BtnHapus"); // NOI18N
        BtnHapus.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });
        BtnHapus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnHapusKeyPressed(evt);
            }
        });
        panelisi1.add(BtnHapus);

        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        BtnPrint.setMnemonic('T');
        BtnPrint.setText("Cetak");
        BtnPrint.setToolTipText("Alt+T");
        BtnPrint.setName("BtnPrint"); // NOI18N
        BtnPrint.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });
        BtnPrint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnPrintKeyPressed(evt);
            }
        });
        panelisi1.add(BtnPrint);

        label10.setText("Record :");
        label10.setName("label10"); // NOI18N
        label10.setPreferredSize(new java.awt.Dimension(95, 30));
        panelisi1.add(label10);

        LCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount.setText("0");
        LCount.setName("LCount"); // NOI18N
        LCount.setPreferredSize(new java.awt.Dimension(300, 30));
        panelisi1.add(LCount);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+K");
        BtnKeluar.setName("BtnKeluar"); // NOI18N
        BtnKeluar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        BtnKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKeluarKeyPressed(evt);
            }
        });
        panelisi1.add(BtnKeluar);

        jPanel1.add(panelisi1, java.awt.BorderLayout.CENTER);

        internalFrame1.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        if(tbKamar.getRowCount()==0){
             JOptionPane.showMessageDialog(null,"Maaf, data sudah habis...!!!!");
             TCari.requestFocus();
        }else if(tbKamar.getSelectedRow()!= -1){            
            if(Sequel.cariRegistrasi(tbKamar.getValueAt(tbKamar.getSelectedRow(),1).toString())>0){
                JOptionPane.showMessageDialog(rootPane,"Data billing sudah terverifikasi, data tidak boleh dihapus.\nSilahkan hubungi bagian kasir/keuangan ..!!");
                TCari.requestFocus();
            }else if(tbKamar.getValueAt(tbKamar.getSelectedRow(),6).toString().equals("")){
                JOptionPane.showMessageDialog(rootPane,"Maaf data stok obat pasien ranap untuk obat ini tidak ditemukan..!!!");
                TCari.requestFocus();
            }else{
                if(aktifkanbatch.equals("yes")){
                    Sequel.mengedit3("data_batch","no_batch=? and kode_brng=? and no_faktur=?","sisa=sisa-?",4,new String[]{
                        ""+tbKamar.getValueAt(tbKamar.getSelectedRow(),4).toString(),tbKamar.getValueAt(tbKamar.getSelectedRow(),7).toString(),tbKamar.getValueAt(tbKamar.getSelectedRow(),5).toString(),tbKamar.getValueAt(tbKamar.getSelectedRow(),8).toString()
                    });
                    Trackobat.catatRiwayat(tbKamar.getValueAt(tbKamar.getSelectedRow(),5).toString(),0,Valid.SetAngka(tbKamar.getValueAt(tbKamar.getSelectedRow(),4).toString()),"Retur Pasien",akses.getkode(),tbKamar.getValueAt(tbKamar.getSelectedRow(),6).toString(),"Hapus",tbKamar.getValueAt(tbKamar.getSelectedRow(),7).toString(),tbKamar.getValueAt(tbKamar.getSelectedRow(),8).toString());                
                    Sequel.menyimpan("gudangbarang","'"+tbKamar.getValueAt(tbKamar.getSelectedRow(),5).toString()+"','"+tbKamar.getValueAt(tbKamar.getSelectedRow(),6).toString()+"','-"+tbKamar.getValueAt(tbKamar.getSelectedRow(),4).toString()+"','"+tbKamar.getValueAt(tbKamar.getSelectedRow(),7).toString()+"','"+tbKamar.getValueAt(tbKamar.getSelectedRow(),8).toString()+"'", 
                                 "stok=stok-'"+tbKamar.getValueAt(tbKamar.getSelectedRow(),4).toString()+"'","kode_brng='"+tbKamar.getValueAt(tbKamar.getSelectedRow(),5).toString()+"' and kd_bangsal='"+tbKamar.getValueAt(tbKamar.getSelectedRow(),6).toString()+"' and no_batch='"+tbKamar.getValueAt(tbKamar.getSelectedRow(),7).toString()+"' and no_faktur='"+tbKamar.getValueAt(tbKamar.getSelectedRow(),8).toString()+"'");                    
                }else{
                    Trackobat.catatRiwayat(tbKamar.getValueAt(tbKamar.getSelectedRow(),5).toString(),0,Valid.SetAngka(tbKamar.getValueAt(tbKamar.getSelectedRow(),4).toString()),"Retur Pasien",akses.getkode(),tbKamar.getValueAt(tbKamar.getSelectedRow(),6).toString(),"Hapus","","");                
                    Sequel.menyimpan("gudangbarang","'"+tbKamar.getValueAt(tbKamar.getSelectedRow(),5).toString()+"','"+tbKamar.getValueAt(tbKamar.getSelectedRow(),6).toString()+"','-"+tbKamar.getValueAt(tbKamar.getSelectedRow(),4).toString()+"','',''", 
                                 "stok=stok-'"+tbKamar.getValueAt(tbKamar.getSelectedRow(),4).toString()+"'","kode_brng='"+tbKamar.getValueAt(tbKamar.getSelectedRow(),5).toString()+"' and kd_bangsal='"+tbKamar.getValueAt(tbKamar.getSelectedRow(),6).toString()+"' and no_batch='' and no_faktur=''");                    
                }
                Sequel.queryu("delete from returpasien where tanggal='"+tbKamar.getValueAt(tbKamar.getSelectedRow(),0).toString()+"' "+
                              "and no_rawat='"+tbKamar.getValueAt(tbKamar.getSelectedRow(),1).toString()+"' "+
                              "and kode_brng='"+tbKamar.getValueAt(tbKamar.getSelectedRow(),5).toString()+"' "+
                              "and no_batch='"+tbKamar.getValueAt(tbKamar.getSelectedRow(),7).toString()+"' "+
                              "and no_faktur='"+tbKamar.getValueAt(tbKamar.getSelectedRow(),8).toString()+"'");
                BtnCariActionPerformed(evt);
            }
        }       
}//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnHapusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnHapusKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnHapusActionPerformed(null);
        }else{
            Valid.pindah(evt, TCari, BtnAll);
        }
}//GEN-LAST:event_BtnHapusKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
}//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            dispose();
        }else{Valid.pindah(evt,BtnAll,TCari);}
}//GEN-LAST:event_BtnKeluarKeyPressed

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BtnCariActionPerformed(evt);
        if(tabMode.getRowCount()==0){
            JOptionPane.showMessageDialog(null,"Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
            TCari.requestFocus();
        }else if(tabMode.getRowCount()!=0){   
            Map<String, Object> param = new HashMap<>();    
            param.put("namars",akses.getnamars());
            param.put("alamatrs",akses.getalamatrs());
            param.put("kotars",akses.getkabupatenrs());
            param.put("propinsirs",akses.getpropinsirs());
            param.put("kontakrs",akses.getkontakrs());
            param.put("emailrs",akses.getemailrs());   
            param.put("logo",Sequel.cariGambar("select logo from setting")); 

            if(TCari.getText().trim().equals("")){
                Valid.MyReportqry("rptReturObatRanap.jasper","report","::[ Retur Obat Ranap ]::",
                      "select returpasien.tanggal, returpasien.no_rawat,concat(reg_periksa.no_rkm_medis,' ',pasien.nm_pasien)as pasien,"+
                      " concat(returpasien.kode_brng,' ',databarang.nama_brng) as barang, returpasien.jml,returpasien.no_batch,returpasien.no_faktur "+
                      "from returpasien inner join reg_periksa inner join pasien inner join databarang "+
                      "on returpasien.no_rawat=reg_periksa.no_rawat and reg_periksa.no_rkm_medis=pasien.no_rkm_medis "+
                      "and returpasien.kode_brng=databarang.kode_brng "+
                      "where returpasien.tanggal between '"+Valid.SetTgl(Tgl1.getSelectedItem()+"")+"' and '"+Valid.SetTgl(Tgl2.getSelectedItem()+"")+"' order by returpasien.tanggal",param);
            }else{
                Valid.MyReportqry("rptReturObatRanap.jasper","report","::[ Retur Obat Ranap ]::",
                      "select returpasien.tanggal, returpasien.no_rawat,concat(reg_periksa.no_rkm_medis,' ',pasien.nm_pasien)as pasien,"+
                      " concat(returpasien.kode_brng,' ',databarang.nama_brng) as barang, returpasien.jml,returpasien.no_batch,returpasien.no_faktur "+
                      "from returpasien inner join reg_periksa inner join pasien inner join databarang "+
                      "on returpasien.no_rawat=reg_periksa.no_rawat and reg_periksa.no_rkm_medis=pasien.no_rkm_medis "+
                      "and returpasien.kode_brng=databarang.kode_brng "+
                      "where returpasien.tanggal between '"+Valid.SetTgl(Tgl1.getSelectedItem()+"")+"' and '"+Valid.SetTgl(Tgl2.getSelectedItem()+"")+"' and returpasien.no_rawat like '%"+TCari.getText().trim()+"%' or "+
                      "returpasien.tanggal between '"+Valid.SetTgl(Tgl1.getSelectedItem()+"")+"' and '"+Valid.SetTgl(Tgl2.getSelectedItem()+"")+"' and reg_periksa.no_rkm_medis like '%"+TCari.getText().trim()+"%' or "+
                      "returpasien.tanggal between '"+Valid.SetTgl(Tgl1.getSelectedItem()+"")+"' and '"+Valid.SetTgl(Tgl2.getSelectedItem()+"")+"' and pasien.nm_pasien like '%"+TCari.getText().trim()+"%' or "+
                      "returpasien.tanggal between '"+Valid.SetTgl(Tgl1.getSelectedItem()+"")+"' and '"+Valid.SetTgl(Tgl2.getSelectedItem()+"")+"' and returpasien.no_batch like '%"+TCari.getText().trim()+"%' or "+
                      "returpasien.tanggal between '"+Valid.SetTgl(Tgl1.getSelectedItem()+"")+"' and '"+Valid.SetTgl(Tgl2.getSelectedItem()+"")+"' and returpasien.no_faktur like '%"+TCari.getText().trim()+"%' or "+
                      "returpasien.tanggal between '"+Valid.SetTgl(Tgl1.getSelectedItem()+"")+"' and '"+Valid.SetTgl(Tgl2.getSelectedItem()+"")+"' and databarang.nama_brng like '%"+TCari.getText().trim()+"%' order by returpasien.tanggal",param);
            }
                
        }
        this.setCursor(Cursor.getDefaultCursor());
}//GEN-LAST:event_BtnPrintActionPerformed

    private void BtnPrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrintKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnPrintActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnHapus, BtnKeluar);
        }
}//GEN-LAST:event_BtnPrintKeyPressed

    private void TCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            BtnCariActionPerformed(null);
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            BtnCari.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_UP){
            BtnKeluar.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_UP){
            tbKamar.requestFocus();
        }
}//GEN-LAST:event_TCariKeyPressed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        tampil();
}//GEN-LAST:event_BtnCariActionPerformed

    private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnCariActionPerformed(null);
        }else{
            Valid.pindah(evt, TCari, BtnAll);
        }
}//GEN-LAST:event_BtnCariKeyPressed

    private void Kd2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Kd2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Kd2KeyPressed

    private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnAllActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnCari, TCari);
        }
    }//GEN-LAST:event_BtnAllKeyPressed

    private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
        TCari.setText("");
        tampil();
    }//GEN-LAST:event_BtnAllActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tampil();
    }//GEN-LAST:event_formWindowOpened

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DlgReturObatPasien dialog = new DlgReturObatPasien(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.Button BtnAll;
    private widget.Button BtnCari;
    private widget.Button BtnHapus;
    private widget.Button BtnKeluar;
    private widget.Button BtnPrint;
    private widget.TextBox Kd2;
    private widget.Label LCount;
    private widget.ScrollPane Scroll;
    private widget.TextBox TCari;
    private widget.Tanggal Tgl1;
    private widget.Tanggal Tgl2;
    private widget.InternalFrame internalFrame1;
    private javax.swing.JPanel jPanel1;
    private widget.Label label10;
    private widget.Label label11;
    private widget.Label label19;
    private widget.Label label9;
    private widget.panelisi panelisi1;
    private widget.panelisi panelisi3;
    private widget.Table tbKamar;
    // End of variables declaration//GEN-END:variables

    private void tampil() {
        Valid.tabelKosong(tabMode);
        try{        
            if(TCari.getText().trim().equals("")){
                pstampil=koneksi.prepareStatement("select returpasien.tanggal, returpasien.no_rawat,concat(reg_periksa.no_rkm_medis,' ',pasien.nm_pasien) as pasien,"+
                      " concat(returpasien.kode_brng,' ',databarang.nama_brng) as barang, returpasien.jml,returpasien.kode_brng,returpasien.no_batch,returpasien.no_faktur "+
                      "from returpasien inner join reg_periksa inner join pasien inner join databarang "+
                      "on returpasien.no_rawat=reg_periksa.no_rawat and reg_periksa.no_rkm_medis=pasien.no_rkm_medis "+
                      "and returpasien.kode_brng=databarang.kode_brng "+
                      "where returpasien.tanggal between ? and ? order by returpasien.tanggal");
            }else{
                pstampil=koneksi.prepareStatement("select returpasien.tanggal, returpasien.no_rawat,concat(reg_periksa.no_rkm_medis,' ',pasien.nm_pasien) as pasien,"+
                      " concat(returpasien.kode_brng,' ',databarang.nama_brng) as barang, returpasien.jml,returpasien.kode_brng,returpasien.no_batch,returpasien.no_faktur "+
                      "from returpasien inner join reg_periksa inner join pasien inner join databarang "+
                      "on returpasien.no_rawat=reg_periksa.no_rawat and reg_periksa.no_rkm_medis=pasien.no_rkm_medis "+
                      "and returpasien.kode_brng=databarang.kode_brng "+
                      "where returpasien.tanggal between ? and ? and returpasien.no_rawat like ? or "+
                      "returpasien.tanggal between ? and ? and reg_periksa.no_rkm_medis like ? or "+
                      "returpasien.tanggal between ? and ? and pasien.nm_pasien like ? or "+
                      "returpasien.tanggal between ? and ? and returpasien.no_batch like ? or "+
                      "returpasien.tanggal between ? and ? and returpasien.no_faktur like ? or "+
                      "returpasien.tanggal between ? and ? and databarang.nama_brng like ? order by returpasien.tanggal");
            }
                
            try {
                if(TCari.getText().trim().equals("")){
                    pstampil.setString(1,Valid.SetTgl(Tgl1.getSelectedItem()+""));
                    pstampil.setString(2,Valid.SetTgl(Tgl2.getSelectedItem()+""));
                }else{
                    pstampil.setString(1,Valid.SetTgl(Tgl1.getSelectedItem()+""));
                    pstampil.setString(2,Valid.SetTgl(Tgl2.getSelectedItem()+""));
                    pstampil.setString(3,"%"+TCari.getText().trim()+"%");
                    pstampil.setString(4,Valid.SetTgl(Tgl1.getSelectedItem()+""));
                    pstampil.setString(5,Valid.SetTgl(Tgl2.getSelectedItem()+""));
                    pstampil.setString(6,"%"+TCari.getText().trim()+"%");
                    pstampil.setString(7,Valid.SetTgl(Tgl1.getSelectedItem()+""));
                    pstampil.setString(8,Valid.SetTgl(Tgl2.getSelectedItem()+""));
                    pstampil.setString(9,"%"+TCari.getText().trim()+"%");
                    pstampil.setString(10,Valid.SetTgl(Tgl1.getSelectedItem()+""));
                    pstampil.setString(11,Valid.SetTgl(Tgl2.getSelectedItem()+""));
                    pstampil.setString(12,"%"+TCari.getText().trim()+"%");
                    pstampil.setString(13,Valid.SetTgl(Tgl1.getSelectedItem()+""));
                    pstampil.setString(14,Valid.SetTgl(Tgl2.getSelectedItem()+""));
                    pstampil.setString(15,"%"+TCari.getText().trim()+"%");
                    pstampil.setString(16,Valid.SetTgl(Tgl1.getSelectedItem()+""));
                    pstampil.setString(17,Valid.SetTgl(Tgl2.getSelectedItem()+""));
                    pstampil.setString(18,"%"+TCari.getText().trim()+"%");
                }
                    
                rstampil=pstampil.executeQuery();
                while(rstampil.next()){              
                    tabMode.addRow(new Object[]{
                        rstampil.getString("tanggal"),rstampil.getString("no_rawat"),rstampil.getString("pasien"),
                        rstampil.getString("barang"),rstampil.getString("jml"),rstampil.getString("kode_brng"),
                        Sequel.cariIsi("select kd_bangsal from stok_obat_pasien where kode_brng='"+rstampil.getString("kode_brng")+"' and no_batch='"+rstampil.getString("no_batch")+"' and no_faktur='"+rstampil.getString("no_faktur")+"'"),
                        rstampil.getString("no_batch"),rstampil.getString("no_faktur")
                    });
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally{
                if(rstampil!=null){
                    rstampil.close();
                }
                if(pstampil!=null){
                    pstampil.close();
                }
            }
        }catch(Exception e){
            System.out.println("Notifikasi : "+e);
        }
        LCount.setText(""+tabMode.getRowCount());
    }

    public JButton getButton(){
        return BtnKeluar;
    }
    
    
    
    public void isCek(){
        BtnHapus.setEnabled(akses.getretur_obat_ranap());
        BtnPrint.setEnabled(akses.getretur_obat_ranap());   
    }
}